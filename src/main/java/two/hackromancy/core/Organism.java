package two.hackromancy.core;

import java.util.ArrayList;

public class Organism {
	protected float x, y;
	protected String id;
	protected int health;
	protected int speed;
	protected ArrayList<State> states = new ArrayList<State>();

	public Organism(float nx, float ny, int health, float speed, String nId) {
		id = nId;
		x = nx;
		y = ny;
	}

	public void moveX() {
		x += speed;
	}

	public void moveY() {
		y += speed;
	}

	public void setX(float nx) {
		x = nx;
	}

	public void changeHealth(float ch) {
		health += ch;
	}

	public void setHealth(float nh) {
		health = nh;
	}

	public float getHealth() {
		return health;
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
		y = cy;
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

	public ArrayList<States> getStates() {
		return states;
	}

	public void runStates() {
		for (State i : states) {
			if (not(i.run())) {states.remove(i);}
		}
	}

	public boolean run() {
		runStates();
		return (health >= 0.0);
	}
}
