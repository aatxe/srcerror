package two.hackromancy.core;

public class FireState extends State {
	private int ticksLeft;
	private int damageDone;
	private Organism organism;

	public FireState(Organism newOrganism, int ticks, int damage) {
		ticksLeft = ticks;
		organism = newOrganism;
		damageDone = damage;
	}

	public FireState(Organism newOrganism, int ticks) {
		ticksLeft = ticks;
		organism = newOrganism;
		damageDone = 15;
	}

	public boolean isRunning() {
		return (ticksLeft > 0);
	}

	public void run() {
		organism.changeHealth(-1 * damageDone);
		ticksLeft--;
	}
}
