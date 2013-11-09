package two.hackromancy.core;

import java.util.ArrayList;
import java.util.HashMap;
public class Player {
	private String userName;
	private ArrayList<Item> items=new ArrayList<Item>();
	private HashMap<Spell> spells;
	public Player(int nx, int ny,String nId,String newUserName,HashMap<Spell> nSpells){
	super(nx,ny,173043,1.0,nId);
	userName=newUserName;
	spells=nSpells;
}
	public void addItem(Item ni){
		items.add(ni);
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
	public ArrayList<Items> getItems(){
		return items;
}
	public void runItems(){
		for(Item i:items){
		if(not(i.run())){items.remove(i);}
		}
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
