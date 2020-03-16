import java.util.*;

public class Test{

    public static void main(String [] args) {

        // ArrayList<Snipe> sinpes = new ArrayList<Snipe>();
        // Random random = new Random();
        // Snipe snipe;

        // for(int i = 0; i< 100; i++){
            
        //     snipe = new Snipe(random.nextBoolean(),
        //                       random.nextBoolean(),
        //                       random.nextBoolean(),
        //                       random.nextBoolean());
            
            
        //     // System.out.println("parent");                  
        //     // System.out.print("longbeak = " + snipe.beakIsLong);
        //     // System.out.print(" fatbody = " + snipe.bodyIsFat);
        //     // System.out.print(" longflier = " + snipe.longDistanceFlier);
            
        //     System.out.println("cgenes = " + snipe.conservativeGenes);
        //     System.out.println( snipe.GetSurvivalChance());
        //     System.out.println(snipe.GetFoodChance());
            
        //     snipe = snipe.GenerateOffspring();
            
        //     System.out.println("offspring\n");
        //     // System.out.print(" longbeak = " + snipe.beakIsLong);
        //     // System.out.print(" fatbody = " + snipe.bodyIsFat);
        //     // System.out.print(" longflier = " + snipe.longDistanceFlier);
        //     // System.out.println(" cgenes = " + snipe.conservativeGenes);
        //     System.out.println(snipe.GetSurvivalChance());
        //     System.out.println(snipe.GetFoodChance());
            
        //     System.out.println('\n');
            
        // }

        int years = 200;
        Enviornment env1 = new Enviornment(true, false);
        Enviornment env2 = new Enviornment(false, false);
        Enviornment env3 = new Enviornment(false, true);
        Enviornment env4 = new Enviornment(true, true);
        
        // Simulation simulate1 = new Simulation  (years,env1);
        Simulation simulate2= new Simulation (years,env2);
        // Simulation simulate3 = new Simulation (years,env3);
        Simulation simulate4 = new Simulation (years,env4);

        // simulate1.RunNewSimulation();
        simulate2.RunNewSimulation();
        // simulate3.RunNewSimulation();
        simulate4.RunNewSimulation();
        
        // simulate1.SummarizeDeaths();
        simulate2.SummarizeDeaths();
        // simulate3.SummarizeDeaths();
        simulate4.SummarizeDeaths();

        // // System.out.println (simulate1.SummarizeDeaths());
        // // System.out.println (simulate2.SummarizeDeaths());
        // // System.out.println (simulate3.SummarizeDeaths());
        // // System.out.println (simulate4.SummarizeDeaths());
    }

}