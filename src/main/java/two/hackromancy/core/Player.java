package two.hackromancy.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Organism {
	private String userName;
	private ArrayList<Item> items = new ArrayList<Item>();
	private HashMap<Spell> spells;

	public Player(int nx, int ny, String nId, String newUserName, HashMap<Spell> nSpells) {
		super(nx, ny, 173043, 1.0, nId);
		userName = newUserName;
		spells = nSpells;
	}

	public void addItem(Item ni) {
		items.add(ni);
	}

	public void castSpell(String name) {
		spells.get(name).cast();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void runItems() {
		for (Item i : items) {
			if (not(i.run())) {items.remove(i);}
		}
	}
}
