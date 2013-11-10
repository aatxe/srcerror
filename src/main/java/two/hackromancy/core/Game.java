package two.hackromancy.core;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/8/13
 */
public class Game {
	private Player player;
	private ArrayList<Noun> nouns;
	private ArrayList<Spell> spells;

	public Game() {
		spells = new ArrayList<Spell>();
		final File folder = new File(".");
		player = new Player(0, 0, "Player-1", "Default-User-Name", getSpells(folder));
		nouns = new ArrayList<Noun>();
		nouns.add(new Mob(nouns, 10, 10, "Mob-1", player));

	}

	public ArrayList<Spell> getSpells(final File folder) {

        	ArrayList<File> pythonFiles = getSpellFiles(folder);
        	ArrayList<Spell> ret = new ArrayList<Spell>();

        	for(final File fileEntry : pythonFiles) {
            		if(fileEntry.getName().substring(fileEntry.getName().length() - 3, fileEntry.getName().length()).equals(".py")) {
                		String newSpellName = fileEntry.getName().substring(0, fileEntry.getName().length() - 3);
                		ret.add(new Spell(newSpellName, nouns, player));
            		}
        	}

        	return ret;
    
    	}
	
	private ArrayList<File> getSpellFiles(final File folder) {
		ArrayList<File> files = new ArrayList<File>();
        	for (final File fileEntry : folder.listFiles()) {
            		if (fileEntry.isDirectory()) {
                		getSpellFiles(fileEntry);
            		} 
            		else {
                		files.add(fileEntry);
            		}
        	}
        	return files;
    	}

	public void update(float ticksPassed) {
		for (int i = 0; i<ticksPassed; i++){
			for (Noun n : nouns) {
				if (!n.run()) {
					nouns.remove(n);
				}
			}
			for (Spell s : spells) {
				if (s.hasCreate()) {
					spells.add(s.create()); // Still a compilation error. s.create() returns 
								// ActiveSpell, not Spell. I don't know what was 
								// meant to be done.
				}
			}
		}
	}

}
