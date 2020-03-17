import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Menu {
	 private ArrayList <String> DeathReports;
	 private boolean plentiful,dangerous;
	 private int years;
	 Menu(){
		 this.plentiful=true;
		 this.dangerous=true;
		 this.years=0;
		 this.DeathReports=new ArrayList<String>();
	 }
	 public void SetSimulationParameters(){
			Scanner scan1=new Scanner(System.in);
			char choice=' ';
			System.out.println("You must enter the initial conditions for the simulation:");
			System.out.println("Enter the number of years of simulation you want to observe:");
			this.years=scan1.nextInt();
			System.out.println("Will the environment be plentiful? Enter y/n:");
			choice=scan1.next().charAt(0);
			if(choice=='y'||choice=='Y'){
				this.plentiful=true;
				
			}
			else if(choice=='n'||choice=='N'){
				this.plentiful=false;
				
			}
			System.out.println("Will the environment be dangerous? Enter y/n:");
			choice=scan1.next().charAt(0);
			if(choice=='y'||choice=='Y'){
				this.dangerous=true;
				
			}
			else if(choice=='n'||choice=='N'){
				this.dangerous=false;
				
			}
			
	 }
	 /**
	  * Method to display Death report on a chart
	  */
	/*@Override
	    public void start(final Stage stage) {
	        stage.setTitle("Project 2");
	 
	        /**
	         * label
	         */
	       /* final Label titleLabel = new Label("Snipe Death Report"); //  must include your name.
	        titleLabel.setFont(Font.font("Verdana",48));
	        titleLabel.setTextFill(Color.CORNFLOWERBLUE);
	        
	        /**
	         * button 
	         */
	       /* final Button button = new Button("Death Report");
	        button.setFont(Font.font("Verdana",20)); 
	        button.setTextFill(Color.TEAL);
	        
	        /**
	         * x and y axis for graph
	         */
	      /*  final NumberAxis xAxis = new NumberAxis();
	        xAxis.setLabel("Snipes");
	        final NumberAxis yAxis = new NumberAxis();             
	        yAxis.setLabel("Deaths");
	        XYChart.Series series = new XYChart.Series();
	       
	        /**
	         * chart
	         */
	    /*   final LineChart lineChart = new LineChart(xAxis, yAxis);
	       
	    
	        /**
	         * panes
	         */ 
	        
	     /*   BackgroundFill background_fill = new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY); 

	        Background background = new Background(background_fill); 
	        final BorderPane topLablePane = new BorderPane();
	        topLablePane.setCenter(titleLabel);
	        
	        final GridPane buttonPane = new GridPane();        
	        buttonPane.setHgap(5);
	        buttonPane.setConstraints(button,78,0);
	        buttonPane.getChildren().add(button);

	        final GridPane chartGridPane = new GridPane();
	        GridPane.setConstraints(lineChart,30,0);
	        chartGridPane.setHgap(5);
	        chartGridPane.setVgap(0);
	        chartGridPane.getChildren().addAll(lineChart);
	       
	        final Pane rootGroup = new VBox(100);
	        rootGroup.getChildren().addAll(topLablePane,chartGridPane,buttonPane);
	        rootGroup.setBackground(background);
	        /**
	         * scenes
	         */
	      /*  Scene scene = new Scene(rootGroup, 1000, 1000); 
	       
	        lineChart.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
	        lineChart.prefHeightProperty().bind(scene.heightProperty().multiply(0.6));
	        
	       
	        
	        stage.setScene(scene); 
	        stage.show();
	        
	        button.setOnAction(
	            (final ActionEvent e) -> { 
	            
	            
	            	
	            
	            
	        });
	      
	     
	    }
	*/ 
	public static void main(String[] args){
		Scanner scan2=new Scanner(System.in);
		Menu menu=new Menu();
		char flag='y';
		int userChoice1=0;
		int userChoice2=0;
		//boolean secondMenu=false;
		do{
			/**
			 * user is asked what they would like to do
			 */
			System.out.println("Select the action you wish to execute:");
			System.out.println("1. Simulate Evolution\n2. View Death Report\n3. Exit Menu");
			userChoice1=scan2.nextInt();
			switch(userChoice1){
			/**
			 * Evolution Simulation
			 */
			case 1:				
				menu.SetSimulationParameters();
				menu.RunSimulation();
				break;
			/**
		     * Death report is shown
			 */
			case 2:
				menu.ReadDeathReport();
				//Application.launch(args);
				break;
			case 3:
				flag='n';
			default:
				System.out.println("Incorrect input");
				break;
			}
		/**
		 * user may return to the login page
		 */		
		System.out.println("Select the action you wish to execute:");
		System.out.println("1. Return to main menu\n2.Exit program");
		userChoice2=scan2.nextInt();
		if(userChoice2==1){
			flag='y';
		}
		else if(userChoice2==2){
			flag='n';
		}
	
				
		
	}while(flag=='y'||flag=='Y');
	}		
		
	
	public void RunSimulation(){  
		Environment environment=new Environment(this.plentiful,this.dangerous);
		Simulation simulation=new Simulation(this.years,environment);
		simulation.RunNewSimulation();
		DeathReports.add(simulation.SummarizeDeaths());
		
		
	}
	public void ReadDeathReport(){
		for(String report:DeathReports){
			System.out.println(report);
		}
		
	}


}
