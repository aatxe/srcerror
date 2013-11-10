package two.hackromancy.core;

public class SlowState extends State {
	int ticksLeft;
	Organism organism;
	int slowFactor;

	public SlowState(Organism organism) {
		this.organism = organism;
	}
	public SlowState(Organism newOrganism, int ticks, int slow) {
		ticksLeft = ticks;
		organism = newOrganism;
		slowFactor = slow;
	}

	public SlowState(Organism newOrganism, int ticks) {
		ticksLeft = ticks;
		organism = newOrganism;
		slowFactor = 15;
	}

	public boolean isRunning() {
		return (ticksLeft > 0);
	}

	public void run() {
		if (ticksLeft > 0) {
			ticksLeft--;
			if (organism.getSpeed() < slowFactor)
				organism.setSpeed(0);
			else
				organism.setSpeed(organism.getSpeed() - slowFactor);
		}
		return (ticksLeft > 0)
	}

}
