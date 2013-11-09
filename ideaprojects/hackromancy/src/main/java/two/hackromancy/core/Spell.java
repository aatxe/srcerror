package two.hackromancy.core;

public class Spell{

	private String spellName;
	private ArrayList<Noun> nouns;
	private Player player;

	public Spell(String newSpellName,Noun newNouns,Player newPlayer){
		spellName=newSpellName;
		newPlayer
	}

	public void cast(){//input if needed into here
		needToMake=true;
	}
	
	public boolean hasCreate(){
		return needToMake;
	}
	public ActiveSpell create(){
		needToMake = false;
        	JythonObjectFactory factory = JythonObjectFactory.getInstance();
        	ActivePlayerSpellType spell = (ActivePlayerSpellType)
             	factory.createObject(ActivePlayerSpellType.class, spellName);
        	return new ActiveSpell(nouns,player,spell);
	}
}
