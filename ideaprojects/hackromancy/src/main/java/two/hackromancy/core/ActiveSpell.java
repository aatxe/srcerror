package two.hackromancy.core;

public class ActiveSpell{
	
	private float x, y;
	private float xVelocity, yVelocity;
	private float speed;
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
		xVelocity=0.0;
		yVelocity=0.0;
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
        	return spell.isAlive();
        }
        public void velocityChange(float xchange,float ychange){
		xVelocity+=xchange;
		yVelocity+=ychange;
		player.changeEnergy((int)(-xchange-ychange))
	}
	public void floodSpeedChange(float radius,float change) {

                    ArrayList<Noun> nouns = nounsWithinRadius(radius);
                    for(int i = 0; i < nouns.size(); i++) {
                        if(nouns.get(i) instanceof Organism) {
                                    nouns.get(i).changeSpeed(change);
                                    player.changeEnergy((int)(-radius-change));
                        }
                    }
        }
        public void floodDamage(float radius,float amount) {

                    ArrayList<Noun> nouns = nounsWithinRadius(radius);
                    for(int i = 0; i < nouns.size(); i++) {
                        if(nouns.get(i) instanceof Organism) {
                                    nouns.get(i).changeHealth(-amount);
                                    player.changeEnergy((int)(-radius+amount*amount));
                        }
                    }
        }
        
        public void floodFireState(float radius) {

        	ArrayList<Noun> nouns = nounsWithinRadius(radius);
        	for(int i = 0; i < nouns.size(); i++) {
            		if(nouns.get(i) instanceof Organism) {
                		nouns.get(i).addState(new FireState());
                		player.changeEnergy((int)(-radius));
            		}
        	}
    	}	
    
    	public void floodSlowState(float radius) {

        	ArrayList<Noun> nouns = nounsWithinRadius(radius);
        	for(int i = 0; i < nouns.size(); i++) {
            		if(nouns.get(i) instanceof Organism) {
                		nouns.get(i).addState(new SlowState());
                		player.changeEnergy((int)(-radius));
            		}
        	}
    	}
    	
    	public void floodCurseState(float radius) {

        	ArrayList<Noun> nouns = nounsWithinRadius(radius);
        	for(int i = 0; i < nouns.size(); i++) {
            		if(nouns.get(i) instanceof Organism) {
                		nouns.get(i).addState(new CurseState());
                		player.changeEnergy((int)(-radius));
            		}
        	}
    	}
    	
    	public void floodRegenState(float radius) {

      	    	ArrayList<Noun> nouns = nounsWithinRadius(radius);
        	for(int i = 0; i < nouns.size(); i++) {
                	if(nouns.get(i) instanceof Organism) {
                    		nouns.get(i).addState(new RegenState());
                    		player.changeEnergy((int)(-radius));
                	}
            	}
        }
        
        public void  floodStunState(float radius) {

            	ArrayList<Noun> nouns = nounsWithinRadius(radius);
            	for(int i = 0; i < nouns.size(); i++) {
                	if(nouns.get(i) instanceof Organism) {
                    		nouns.get(i).addState(new StunState());
                    		player.changeEnergy((int)(-radius));
                	}
            	}
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
		spell.run();
		//if(spell.isDamaging())damage(spell.damage());
		x+=xVelocity;
		y+=yVelocity;
		if(spell.isCurseStating())
           	    floodStunState(spell.getCurseStateRadius());
        	if(spell.isFireStating())
            	    floodFireState(spell.getFireStateRadius());
        	if(spell.isRegenStating())
            	    floodRegenState(spell.getRegenStateRadius());
        	if(spell.isSlowStating())
            	    floodSlowState(spell.getSlowStateRadius());
        	if(spell.isStunStating())
            	    floodStunState(spell.getStunStateRadius());
            	if(spell.isSpeedChanging())
            	    floodStunState(spell.getSpeedChangeRadius(),spell.getSpeedChangeAmount());
            	if(spell.isFloodDamaging())
            	    floodStunState(spell.getDamagingRadius(),spell.getDamagingAmount());
            	if(spell.isVelocityChanging())
            	    floodStunState(spell.getXVelocityChange(),spell.getYVelocityChange());
            	
            		
		return spell.isAlive();
	}
}
