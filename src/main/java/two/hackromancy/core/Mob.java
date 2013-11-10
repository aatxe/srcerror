package two.hackromancy.core;

import java.util.ArrayList;

public class Mob extends Organism {
	private Player player;
	private int energy;
	private ArrayList<Noun> worldNouns;
	private Vector vector;
	
	public Mob(ArrayList<Noun> nouns, int nx, int ny, String nId, Player newPlayer) {
		super(nx, ny, 173043, 0.8f, nId);
		worldNouns = nouns;
		player = newPlayer;
		energy = 0;
		vector = new Vector(0);
	}

	public String getId() {
		return super.id;
	}
	
	public Vector getVector() {
		return vector;
	}
	private ArrayList<Noun> nounsWithinRadius(float radius) {
		ArrayList<Noun> nounsInRadius = new ArrayList<Noun>();
		for (int i = 0; i < worldNouns.size(); i++) {
			Noun curr = worldNouns.get(i);
			float dist = (float)Math.sqrt((curr.getX() - x) * (curr.getX() - x) + (curr.getY() - y) * (curr.getY() - y));
			if (dist <= radius) nounsInRadius.add(curr);
		}

		return nounsInRadius;
	}

	private float distToPlayer() {
		return (float)Math.sqrt((player.getX() - x) * (player.getX() - x) + (player.getY() - y) * (player.getY() - y));

	}

	private void move() {
		changeX(speed * (float)Math.cos(Math.acos(Math.abs(player.getX() - x) / distToPlayer())));
		changeY(speed * (float)Math.sin(Math.acos(Math.abs(player.getX() - x) / distToPlayer())));
	}

	private void changeX(float newX) {
        	super.setX(newX);
    	}
    
    	private void changeY(float newY) {
        	super.setY(newY);
    	}
    	
	private void attack() {
		if ((distToPlayer() < 10.0) && (energy >= 100)) {
			player.changeHealth(-25.0f);
			energy = 0;
		}
	}

	public boolean run() {
		energy += 1;
		move();
		attack();
		return (health >= 0.0);
	}
}
