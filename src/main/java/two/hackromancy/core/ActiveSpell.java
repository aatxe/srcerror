package two.hackromancy.core;

import java.util.ArrayList;

public class ActiveSpell {
	private String id;
	private float x, y;
	private float xVelocity, yVelocity;
	private boolean pushInProgess;
	private ArrayList<Noun> worldNouns;
	private ArrayList<Organism> pushNouns;
	private ArrayList<Float> pushX, pushY;
	private Player player;
	private ActivePlayerSpellType spell;

	public ActiveSpell(ArrayList<Noun> newNouns, Player newPlayer, ActivePlayerSpellType newSpell, String id) {
		player = newPlayer;
		worldNouns = newNouns;
		x = player.getX();
		y = player.getY();
		spell = newSpell;
		this.id = id;
		xVelocity = 0.0f;
		yVelocity = 0.0f;
		pushNouns = new ArrayList<Organism>();
		pushX = new ArrayList<Organism>();
		pushY = new ArrayList<Organism>();
	}

	public void changeXVelocity(float velocity) {
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

	public void velocityChange(float xchange, float ychange) {
		changeXVelocity(xchange);
		changeYVelocity(ychange);
		player.changeEnergy((int) (-xchange - ychange));
	}


	public void floodDamage(float radius, float amount) {
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Organism) {
				Organism temp = (Organism)nouns.get(i);
				temp.changeHealth(-amount);
				player.changeEnergy((int) (-radius - amount * amount));
			}
		}
	}

	public void floodFireState(float radius) {
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Organism) {
				Organism temp = (Organsim)nouns.get(i);
				temp.addState(new FireState(temp));
				player.changeEnergy((int) (-radius));
			}
		}
	}

	public void floodSlowState(float radius) {
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Organism) {
				Organism temp = (Organism)nouns.get(i);
				temp.addState(new SlowState(temp));
				player.changeEnergy((int) (-radius));
			}
		}
	}

	public void floodCurseState(float radius) {
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Organism) {
				Organism temp = (Organism)nouns.get(i);
				temp.addState(new CurseState(temp));
				player.changeEnergy((int) (-radius));
			}
		}
	}

	public void floodRegenState(float radius) {
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Organism) {
				nouns.get(i).addState(new RegenState());
				player.changeEnergy((int) (-radius));
			}
		}
	}

	public void floodStunState(float radius) {
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Organism) {
				nouns.get(i).addState(new StunState());
				player.changeEnergy((int) (-radius));
			}
		}
	}

	private ArrayList<Noun> nounsWithinRadius(float radius) {
		ArrayList<Noun> nounsInRadius = new ArrayList<Noun>();
		for (int i = 0; i < worldNouns.size(); i++) {
			Noun curr = worldNouns.get(i);
			float dist = (float)Math.sqrt((curr.getX() - x) * (curr.getX() - x) + (curr.getY() - y) * (curr.getY() - y));
			if (dist <= radius)
				nounsInRadius.add(curr);
		}
		return nounsInRadius;
	}
	private int organismsInRadius(float radius){
		int ret=0;
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Organism) {
				ret++;
			}
		}
		return ret;
	}
	private boolean playerInRadius(float radius){
		ArrayList<Noun> nouns = nounsWithinRadius(radius);
		for (int i = 0; i < nouns.size(); i++) {
			if (nouns.get(i) instanceof Player) {
				return true;
			}
		}
		return false;
	}
	public void floodPush(float radius) {
		int increment = 5;
		if (pushNouns.size() == 0) {
			ArrayList<Noun> temp = nounsWithinRadius(radius);
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i) instanceof Organism)
					pushNouns.add(temp.get(i));
			}
			pushInProgress = true;
			for (int i = 0; i < pushNouns.size(); i++) {
				pushX.add(pushNouns.get(i).getX() + player.getEnergy());
				pushY.add(pushNouns.get(i).getY() + player.getEnergy());
			}
		}
		if (pushNouns.get(0).getX() != pushX.get(0)) {
			for (int i = 0; i < pushNouns.size(); i++) {
				pushNouns.get(i).setX(pushNouns.get(i).getX() + increment);
				pushNouns.get(i).setY(pushNouns.get(i).getY() + increment);
			}
		} else {
			pushNouns.clear();
			pushInProgress = false;
			pushX.clear();
			pushY.clear();
		}
	}

	public boolean run() {
		spell.run();
		x += xVelocity;
		y += yVelocity;
		if (spell.isCurseStating())
			floodCurseState(spell.getCurseStateRadius());
		if (spell.isFireStating())
			floodFireState(spell.getFireStateRadius());
		if (spell.isRegenStating())
			floodRegenState(spell.getRegenStateRadius());
		if (spell.isSlowStating())
			floodSlowState(spell.getSlowStateRadius());
		if (spell.isStunStating())
			floodStunState(spell.getStunStateRadius());
		if (spell.isFloodDamaging())
			floodDamage(spell.getDamagingRadius(), spell.getDamagingAmount());
		if (spell.isVelocityChanging())
			velocityChange(spell.getXVelocityChange(), spell.getYVelocityChange());
		if (spell.isGetOrganismsInRadius())
			spell.areOrganismsInRadius(organismsInRadius(spell.getOrganismsInRadius()));
		if(spell.isGetPlayerInRadius())
			spell.isPlayerInRadius(playerInRadius(spell.getPlayerInRadius()));
		return spell.isAlive();
	}
}
