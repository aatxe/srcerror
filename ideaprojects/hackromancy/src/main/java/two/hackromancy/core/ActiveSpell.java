package two.hackromancy.core;

public class ActiveSpell{
	
	private float x;
	private float y;
	private float speed;
	private ArrayList<Noun> nouns;
	private Player player;
	private ActivePlayerSpellType spell;
	
	public ActiveSpell(ArrayList<Noun> newNouns, Player newPlayer,ActivePlayerSpellType newSpell){
		player = newPlayer
		nouns = newNouns;
		x = player.getX();
		y = player.getY();
		spell = newSpell;
		speed = 2.0;
	}
	
	private void changeXVelcoity(float velocity) {
        	xVelocity += velocity;
    	}

        private void changeYVelocity(float velocity) {
       	     yVelocity += velocity;
        }
	//add methods like damage which do damage to enerything within a radius
	public boolean run(){
		//if(spell.isDamaging())damage(spell.damage());
		
		return spell.isAlive();
	}
}
