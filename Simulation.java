import java.util.*;

public class Simulation
{
    public int numYears;
    public Enviornment env;
    
    private int numSnipes;
    private int numPredators;
    private int numSnoozeberries;
    
    private ArrayList <DeathReport> deaths;
    private ArrayList <Snipe> snipes;
    private ArrayList <Snipe> offSprings;
    
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
        
        Snipe subject, previous;
        previous = new Snipe(random.nextBoolean(),
                            random.nextBoolean(),
                            random.nextBoolean(),
                            random.nextBoolean());

        initSimulation();
        
        for (int i = 0; i<numYears; i++){

            for (int j = 0; j< snipes.size(); j++){

                subject = snipes.get(j);
                
                //find food
                if (random.nextDouble() < subject.GetFoodChance()){
                    this.numSnoozeberries -= 1;
                    subject.energy = subject.energyRequired + 1;
                }
                
                //avoid predetor
                if (random.nextDouble() < subject.GetSurvivalChance() ){
                    subject.LoseEnergy(1);
                }
                else{
                    subject.isAlive = false;
                }

                //offspring
                if (subject.isAlive && j%2 == 1){
                    int k = j;
                    while (k<0){
                        previous = snipes.get(k);
                        if (previous.isAlive){
                            break;
                        }
                        else{
                            k--;
                        }
                    }

                    if(random.nextBoolean()){
                        this.offSprings.add(previous.GenerateOffspring());
                    }
                    else{
                        this.offSprings.add(subject.GenerateOffspring());
                    }
                }

                //increament age
                subject.age += 1;

                //lose energy
                subject.LoseEnergy(subject.energyRequired);

            }

            this.snipes.addAll(offSprings);
            Collections.shuffle(snipes);
            offSprings.clear();
        
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