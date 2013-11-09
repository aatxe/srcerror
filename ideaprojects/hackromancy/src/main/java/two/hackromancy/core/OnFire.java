package two.hackromancy.core;
public class OnFire extends State{
	int ticksLeft;
	Organism organism;
    public OnFire(Organism newOrganism,int ticks){
	ticksLeft=ticks;
	organsim=newOrgansim;
}

    public boolean isRunning(){
	return (ticksLeft>0)
}
    public void run(){
	organism.changeHealth(15);
	ticksLeft--;

}

}
