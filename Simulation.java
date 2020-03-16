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
        this.numSnoozeberries = 200; 
        
        this.deaths = new ArrayList<DeathReport>();
        this.snipes = new ArrayList<Snipe>();
        this.offSprings = new ArrayList<Snipe>();
    }

    public void RunNewSimulation(){
        
        // CauseOfDeath starvation = CauseOfDeath.Starvation;
        // CauseOfDeath predation = CauseOfDeath.Predation;
        
        initSimulation();
        
        Snipe subject, previous;
        previous = new Snipe(random.nextBoolean(),
                             random.nextBoolean(),
                             random.nextBoolean(),
                             random.nextBoolean());
        
        DeathReport deathReport = new DeathReport(0,0, CauseOfDeath.Predation);
        
        for (int i = 0; i<numYears; i++){


            for (int j = 0; j< snipes.size(); j++){

                subject = snipes.get(j);
                
                //find food
                if (random.nextDouble() < subject.GetFoodChance()){
                    this.numSnoozeberries -= 1;
                    subject.energy += 4;
                }
                
                //avoid predetor
                if ( random.nextBoolean() || (random.nextBoolean() && random.nextBoolean())){
                    
                    if (random.nextDouble() < subject.GetSurvivalChance() ){
                        subject.LoseEnergy(1);
                    }
                    else{
                        
                        subject.isAlive = false;
                        
                        deathReport.age = subject.age;
                        deathReport.year = i;
                        deathReport.cause = CauseOfDeath.Predation;
                        
                        deaths.add(deathReport);
                        snipes.remove(j);

                    }
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

                    //only if a living mate is found
                    if (k != 0){
                        
                        if(random.nextBoolean()){
                            this.offSprings.add(previous.GenerateOffspring());
                        }
                        else{
                            this.offSprings.add(subject.GenerateOffspring());
                        }
                    }

                }
            
                //increament age
                subject.age += 1;

                //lose energy
                subject.LoseEnergy(subject.energyRequired);

                if (!subject.isAlive){
                    
                    deathReport.age = subject.age;
                    deathReport.year = i;
                    deathReport.cause = CauseOfDeath.Starvation;
                    
                    deaths.add(deathReport);
                    snipes.remove(j);

                }

                
            }


            this.snipes.addAll(offSprings);
            Collections.shuffle(snipes);
            offSprings.clear();

            if(this.env.isPlentiful){
                this.numSnoozeberries += 400;
            }
            else{
                this.numSnoozeberries += 200;
            }

            if (this.numSnoozeberries > 600 ){
                this.numSnoozeberries = 600;
            }
        
        }


        return;
    }

    public String SummarizeDeaths(){

        int noStarvation = 0;
        int noPredation = 0;
        String report;
        
        Iterator<DeathReport> itr = this.deaths.iterator();
        while(itr.hasNext()){
            if(itr.next().cause == CauseOfDeath.Predation){
                noStarvation += 1;
            }else{
                noPredation += 1;
            }
        }

        report = "No. of Deaths = "+ this.deaths.size();
        report += ". No of Deaths due to starvation = " + noStarvation;
        report += ". No of Death due to predation = " + noPredation + ".";

        return report;
    }
    
    private void initSimulation(){

    
        if(this.env.isDangerous){
            this.numPredators = 400;
        }
        
        if (this.env.isPlentiful){
            this.numSnoozeberries = 400;
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