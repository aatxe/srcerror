package two.hackromancy.core;

public class CurseState extends State {
	int ticksLeft;
	Organism organism;
	int curseFactor;

	public CurseState(Organism organism) {
		this.organism = organism;
	}
	public CurseState(Organism newOrganism, int ticks, int curse) {
		ticksLeft = ticks;
		organism = newOrganism;
		curseFactor = curse;
	}

	public CurseState(Organism newOrganism, int ticks) {
		ticksLeft = ticks;
		organism = newOrganism;
		curseFactor = 5;
	}

	public boolean isRunning() {
		return (ticksLeft > 0);
	}

	public void run() {
		if (ticksLeft > 0) {
			ticksLeft--;
			organism.changeMaxHealth(-1 * curseFactor);
			if (organism.getMaxHealth < 0)
				organism.setMaxHealth(0);

		}
		return; // (ticksLeft > 0);;
	}

}
