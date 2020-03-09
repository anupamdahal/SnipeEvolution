import java.util.*;

public class Simulation
{
    public int numYears;
    public Enviornment env;
    
    private int numSnipes;
    private int numPredators;
    private int numSnoozeberries;
    
    private List <DeathReport> deaths;
    private List <Snipe> snipes;
    private List <Snipe> offSprings;
    
    Random random = new Random();
    
    public Simulation(int years, Enviornment environment){
        
        this.numYears = years;
        this.env = environment;
        
        this.numSnipes = 300;
        this.numPredators = 200;
        this.numSnoozeberries = 300; 
        
        this.deaths = new ArrayList<DeathReport>();
        this.snipes = new ArrayList<Snipe>();
        this.offSprings = new ArrayList<Snipe>();
    }

    public void RunNewSimulation(){
        
        initSimulation();
        
        for (int i = 0; i<numYears; i++){

            this.snipes.addAll(offSprings);
            offSprings.clear();

            for (int j = 0; j<snipes.size(); j++){

                //find food
                //avoid predetor

                //offspring

                //increament age

                //lose energy

            }

        }

        return;
    }

    public String SummarizeDeaths(){
        
        Iterator<DeathReport> itr = this.deaths.iterator();
        while(itr.hasNext()){
            
        }
        return null;
    }

    public DeathReport GetDeathReport(){
        return null;
    }
    
    private void initSimulation(){

    
        if(this.env.isDangerous){
            this.numPredators = 400;
        }
        
        if (this.env.isPlentiful){
            this.numSnoozeberries = 600;
        }
    
        for(int i = 0; i<numSnipes; i++){
            Snipe snipe = new Snipe(random.nextBoolean(),
                                    random.nextBoolean(),
                                    random.nextBoolean(),
                                    random.nextBoolean());

            this.snipes.add(snipe);
        }

    }
}