package two.hackromancy.core;
public class FireState extends State{
	int ticksLeft;
	int damageDone;
	Organism organism;
    public FireState(Organism newOrganism,int ticks, int damage){
	ticksLeft=ticks;
	organism=newOrganism;
	damageDone=damage;
    public FireState(Organism newOrganism,int ticks){
	ticksLeft=ticks;
	organism=newOrganism;
	damageDone=15;
}

    public boolean isRunning(){
	return (ticksLeft>0)
}
    public void run(){
	organism.changeHealth(damageDone);
	ticksLeft--;

}

}
