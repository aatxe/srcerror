package two.hackromancy.core;

public class StunState extends State {
	int ticksLeft;
	Organism organism;

	public StunState(Organism newOrganism, int ticks) {
		ticksLeft = ticks;
		organism = newOrganism;
	}

	public boolean isRunning() {
		return (ticksLeft > 0);
	}

	public void run() {
		if (ticksLeft > 0) {
			ticksLeft--;
			organism.setSpeed(0);
		}
		return; // (ticksLeft > 0)
	}

}
