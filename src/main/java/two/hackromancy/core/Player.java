package two.hackromancy.core;

import java.util.ArrayList;

public class Player extends Organism {
	private String userName;
	private ArrayList<Spell> spells;
	private int energy = 2000;

	public Player(float nx, float ny, String nId, String newUserName, ArrayList<Spell> nSpells) {
		super(nx, ny, 173043, 1.0f, nId);
		userName = newUserName;
		spells = nSpells;
	}

	public void castSpell(String name) {
		for (Spell i : spells) {
			if (i.getName().equals(name)) {
				i.cast();
				break;
			}
		}
	}

	public void addSpell(Spell newSpell) {
		spells.add(newSpell);
	}

	public void removeSpell(String name) {
		for (Spell i : spells) {
			if (i.getName().equals(name)) {
				spells.remove(i);
				break;
			}
		}
	}

	public int getEnergy() {
		return energy;
	}

	public void changeEnergy(int delta) {
		energy += delta;
	}

	public void regen() {
		changeHealth(10);
		changeEnergy(10);
	}

	public boolean run() {
		runStates();
		regen();
		return (health >= 0.0);
	}
}
