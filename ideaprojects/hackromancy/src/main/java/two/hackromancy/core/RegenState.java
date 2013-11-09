package two.hackromancy.core;

public class RegenState extends State{
   private int ticksLeft;
   private int healthDone;
   private Organism organism;
    
    public RegenState(Organism newOrganism,int ticks, int health){
        ticksLeft=ticks;
        organism=newOrganism;
        healthDone=health;
    }
            
    public RegenState(Organism newOrganism,int ticks){
        ticksLeft=ticks;
        organism=newOrganism;
        healthDone=15;
    }

    public boolean isRunning(){
        return (ticksLeft>0);
    }
    public void run(){
        if(ticksLeft>0)
        {
            organism.changeHealth(healthDone);
            ticksLeft--;
        }
        return ticksLeft;
    }
}
