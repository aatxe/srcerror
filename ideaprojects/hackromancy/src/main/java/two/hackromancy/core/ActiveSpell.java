package two.hackromancy.core;

public class ActiveSpell{
	
	private float x, y;
	private float xVelocity, yVelocity;
	private float speed;
	private boolean alive;
	private ArrayList<Noun> worldNouns;
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
        private ArrayList<Noun> nounsWithinRadius(float radius) {

        	ArrayList<Noun> nounsInRadius = new ArrayList<Noun>();
        	for(int i = 0; i < worldNouns.size(); i++) {
            		Noun curr = worldNouns.get(i);
            		float dist = Math.sqrt((curr.getX() - x) * (curr.getX() - x) + (curr.getY() - y) * (curr.getY() - y));
        		if(dist <= radius)
                		nounsInRadius.add(curr);
        	}

        	return nounsInRadius;
    	}
	//add methods like damage which do damage to enerything within a radius
	public boolean run(){
		//if(spell.isDamaging())damage(spell.damage());
		alive = true;
		return spell.isAlive();
	}
}
