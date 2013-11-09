package two.hackromancy.core;

public class OnFire extends State{
	int ticksLeft;
	int damageDone
	Organism organism;
    
    	public OnFire(Organism newOrganism,int ticks, int damage){
		ticksLeft=ticks;
		organism=newOrganism;
		damageDone=damage;
    	}
    	
    	public OnFire(Organism newOrganism,int ticks){
		ticksLeft=ticks;
		organism=newOrganism;
		damageDone=15;
	}

    	public void run(){
		organism.changeHealth(damageDone);
		ticksLeft--;
		return (ticksLeft>0);
	}
}
