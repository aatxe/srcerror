package two.hackromancy.core;

import java.util.ArrayList;

public class Mob extends Organism {
	private Player player;
	private int energy;

	public Mob(int nx, int ny, String nId, Player newPlayer) {
		super(nx, ny, 173043, 0.8, nId);
		player = newPlayer;
		energy = 0;
	}

	private ArrayList<Noun> nounsWithinRadius(float radius) {
		ArrayList<Noun> nounsInRadius = new ArrayList<Noun>();
		for (int i = 0; i < worldNouns.size(); i++) {
			Noun curr = worldNouns.get(i);
			float dist = Math.sqrt((curr.getX() - x) * (curr.getX() - x) + (curr.getY() - y) * (curr.getY() - y));
			if (dist <= radius) nounsInRadius.add(curr);
		}

		return nounsInRadius;
	}

	private float distToPlayer() {
		return Math.sqrt((player.getX() - x) * (player.getX() - x) + (player.getY() - y) * (player.getY() - y));

	}

	private void move() {
		changeX(speed * Math.cos(Math.arcos(Math.abs(player.getX() - x) / distToPlayer())));
		changeY(speed * Math.sin(Math.arcos(Math.abs(player.getX() - x) / distToPlayer())));
	}

	private void attack() {
		if ((distToPlayer() < 10.0) && (energy >= 100)) {
			player.changeHealth(-25.0);
			energy = 0;
		}
	}

	private boolean run() {
		energy += 1;
		move();
		attack();
		return (health >= 0.0);
	}
}
