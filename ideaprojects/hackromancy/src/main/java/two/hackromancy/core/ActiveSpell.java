package two.hackromancy.core;

public class ActiveSpell{
	
	private float x, y;
	private float xVelocity, yVelocity;
	private float speed;
	private boolean alive;
	private ArrayList<Noun> nouns;
	private Player player;
	private ActivePlayerSpellType spell;
	
	public ActiveSpell(ArrayList<Noun> newNouns, Player newPlayer,ActivePlayerSpellType newSpell, String id){
		player = newPlayer
		nouns = newNouns;
		x = player.getX();
		y = player.getY();
		spell = newSpell;
		speed = 2.0;
		this.id = id;
	}
	
	public void changeXVelcoity(float velocity) {
        	xVelocity += velocity;
    	}

        public void changeYVelocity(float velocity) {
       	     yVelocity += velocity;
        }
        
        public String getID() {
        	return id;
        }
        
        public boolean isAlive() {
        	return alive;
        }
        
	//add methods like damage which do damage to enerything within a radius
	public boolean run(){
		//if(spell.isDamaging())damage(spell.damage());
		alive = true;
		return spell.isAlive();
	}
}
