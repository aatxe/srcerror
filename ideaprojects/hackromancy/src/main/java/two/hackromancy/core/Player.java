package two.hackromancy.core;

import java.util.ArrayList;
import java.util.HashMap;
public class Player extends Organism{
	private String userName;
	private HashMap<Spell> spells;
	public Player(int nx, int ny,String nId,String newUserName,HashMap<Spell> nSpells){
	super(nx,ny,173043,1.0,nId);
	userName=newUserName;
	spells=nSpells;
}
	public void castSpell(String name){
	spells.get(name).cast();
}
	public void addSpell(Spell newSpell){
	spells.put(newSpell.toString(),newSpell);
}
	public void removeSpell(String name){
	spells.remove(name);
}

	public void regen(){
	changeHealth(10);
	}

	public boolean run(){
		runStates();
		runItems();
		regen();
		return (health >= 0.0);
	}
}
