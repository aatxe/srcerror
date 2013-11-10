package two.hackromancy.core;

import java.util.ArrayList;

public class Organism extends Noun {
	protected float x, y;
	protected String id;
	protected float health;
	protected float maxHealth;
	protected float speed;
	protected ArrayList<State> states = new ArrayList<State>();
	private Vector vector;
	
	public Organism(float nx, float ny, int nMaxHealth, float nspeed, String nId) {
		id = nId;
		x = nx;
		y = ny;
		health = nMaxHealth;
		maxHealth = nMaxHealth;
		vector = new Vector(0);
	}
	public String getId()
	{
		return id;
	}

	public Vector getVector() {
		return vector;
	}
	public void left() {
		x += speed;
	}

	public void right() {
		x -= speed;
	}

	public void up() {
		y += speed;
	}

	public void down() {
		y -= speed;
	}

	public void setX(float nx) {
		x = nx;
	}

	public void changeHealth(float ch) {
		health += ch;
		if (health > maxHealth) health = maxHealth;
	}

	public void setHealth(float nh) {
		health = nh;
		if (health > maxHealth) health = maxHealth;
	}

	public void changeMaxHealth(float ch) {
		maxHealth += ch;
	}

	public void setMaxHealth(float nh) {
		maxHealth = nh;
	}

	public float getHealth() {
		return health;
	}

	public float getMaxHealth() {
		return maxHealth;
	}


	public void changeSpeed(float cs) {
		speed += cs;
	}

	public void setSpeed(float ns) {
		speed = ns;
	}

	public float getSpeed() {
		return speed;
	}

	public void setY(float ny) {
		y = ny;
	}

	public float getY() {
		return y;
	}

	public float getX() {
		return x;
	}

	public void addState(State ns) {
		states.add(ns);
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public void runStates() {
		for (State i : states) {
			if (!(i.isRunning())) {states.remove(i);}
		}
	}

	public boolean run() {
		runStates();
		return (health >= 0.0);
	}
}
