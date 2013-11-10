package two.srcerror.core.nouns;

import two.srcerror.core.Controller;
import two.srcerror.core.Noun;
import two.srcerror.core.State;
import two.srcerror.util.Constants;
import two.srcerror.util.Vector;

import java.util.List;

public abstract class Organism implements Noun {
	private static int organismCount = 0;
	private String identifier;
	private Vector position;
	private Vector velocity;
	private int currentHealth, maxHealth;
	private List<State> states;

	public Organism(int maxHealth) {
		this(maxHealth, Vector.zero, Vector.zero);
	}

	public Organism(int maxHealth, Vector position, Vector velocity) {
		this("Organism-" +  nextUnique(), maxHealth, position, velocity);
	}

	protected Organism(String identifier, int maxHealth, Vector position, Vector velocity) {
		this.identifier = identifier;
		this.maxHealth = maxHealth;
		currentHealth = maxHealth;
		this.position = position;
		this.velocity = velocity;
	}


	public void heal(int health) {
		currentHealth += health;
		if (currentHealth > maxHealth)
			currentHealth = maxHealth;
	}

	public void hurt(int health) {
		currentHealth -= health;
	}

	@Override
	public boolean isAlive() {
		return (currentHealth > 0);
	}

	@Override
	public String identifier() {
		return identifier;
	}

	@Override
	public Vector position() {
		return position;
	}

	@Override
	public Vector velocity() {
		return velocity;
	}

	@Override
	public void tick() {
		controller().tick();
		for (State state : states) {
		 	if (state.isActive())
			    state.tick();
			else
			    states.remove(state);
		}
	}

	public abstract class OrganismController implements Controller {
		@Override
		public void moveX() {
			position = position.add(new Vector(velocity.getX()));
		}

		@Override
		public void accelerateX() {
			velocity = velocity.add(new Vector(Constants.ACCELERATION));
		}

		@Override
		public void decelerateX() {
			velocity = velocity.sub(new Vector(Constants.ACCELERATION));
		}

		@Override
		public void moveY() {
			position = position.add(new Vector(0, velocity.getY()));
		}

		@Override
		public void accelerateY() {
			velocity = velocity.add(new Vector(0, Constants.ACCELERATION));
		}

		@Override
		public void decelerateY() {
			velocity = velocity.sub(new Vector(0, Constants.ACCELERATION));
		}
	}

	public static int nextUnique() {
		return organismCount++;
	}
}
