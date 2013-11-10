package two.hackromancy.core;

import java.util.ArrayList;

public class Spell {
	private String spellName;
	private ArrayList<Noun> nouns;
	private Player player;
	private boolean needToMake;

	public Spell(String newSpellName, ArrayList<Noun> newNouns, Player newPlayer) {
		spellName = newSpellName;
		nouns = newNouns;
		player = newPlayer;
	}

	public String getName() {
		return spellName;
	}

	public void cast() {//input if needed into here
		needToMake = true;
	}

	public boolean hasCreate() {
		return needToMake;
	}

	public ActiveSpell create() {
		needToMake = false;
		JythonObjectFactory factory = JythonObjectFactory.getInstance();
		ActivePlayerSpellType spell = (ActivePlayerSpellType)
				factory.createObject(ActivePlayerSpellType.class, spellName);
		return new ActiveSpell(nouns, player, spell);
	}
}
