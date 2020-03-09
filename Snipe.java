import java.util.*;

public class Snipe
{
  public boolean beakIsLong;
  public boolean bodyIsFat;
  public boolean longDistanceFlier;
  public boolean conservativeGenes;
  public boolean isAlive;
  public int age;
  public int energy;
  
  private int energyRequired;
  private float predatorSurvivalChance;
  private float foodChance;
  private Snipe offSpring;

  Random random = new Random();

  public Snipe(boolean longbeak, boolean fatbody, boolean longflier, boolean cgenes)
  {
    
    this.isAlive = true;
    this.energyRequired = 2;
    
    this.beakIsLong = longbeak;
    this.bodyIsFat = fatbody;
    this.longDistanceFlier = longflier;
    this.conservativeGenes = cgenes;
    this.energy = 2;
    this.age = 0;

    if (this.beakIsLong){
      this.predatorSurvivalChance -= 0.05;
      this.foodChance += 0.1;
    }
    else{
      predatorSurvivalChance += 0.05;
      foodChance -= 0.1;
    }

    if (this.bodyIsFat){
      this.predatorSurvivalChance -= 0.1;
      if (random.nextBoolean()){
        this.energyRequired = 1;
      }
    }
    else{
      this.predatorSurvivalChance += 0.1;
      if (random.nextBoolean() && random.nextBoolean()){
        this.energyRequired = 3;
      }
      
    }

    if (this.longDistanceFlier){
      this.foodChance += 0.2;
      this.predatorSurvivalChance -= 0.1;
    }
    else{
      this.predatorSurvivalChance += 0.2;
      this.foodChance -= 0.1;
    }
  
  }
  
  public float GetFoodChance ()
  {
    return this.foodChance;
  }

  public float GetSurvivalChance ()
  {
    return this.predatorSurvivalChance;
  }

  public Snipe GenerateOffspring ()
  {
    if (this.conservativeGenes){
      offSpring = new Snipe(this.beakIsLong, this.bodyIsFat, this.longDistanceFlier, this.conservativeGenes);
    }
    else{
      if(random.nextBoolean() || random.nextBoolean()){
        offSpring = new Snipe(this.beakIsLong, this.bodyIsFat, this.longDistanceFlier, this.conservativeGenes);
      }
      else{
        offSpring = new Snipe(!this.beakIsLong, !this.bodyIsFat, !this.longDistanceFlier, !this.conservativeGenes);
      }
    }

    return this.offSpring;
  }

  public void LoseEnergy (int e)
  {
    if ((this.energy - e) > 0 ){
      this.energy -= e;
    }
    else{
      if (!(bodyIsFat && this.age < 1)){
        isAlive = false;
      }
    }
  }

}