package two.hackromancy.core;
import java.util.Math;
public class Mob extends Organism{
	Player player;
	public Mob(int nx, int ny,String nId,Player newPlayer){
		super(nx,ny,173043,0.8,nId);
		player=newPlayer;
	}
     	private ArrayList<Noun> nounsWithinRadius(float radius) {

                ArrayList<Noun> nounsInRadius = new ArrayList<Noun>();
                for(int i = 0; i < worldNouns.size(); i++) {
                            Noun curr = worldNouns.get(i);
                            float dist = Math.sqrt((curr.getX() - x) * (curr.getX() - x) + (curr.getY() - y) * (curr.getY() - y));
                        if(dist <= radius)nounsInRadius.add(curr);
                }

                return nounsInRadius;
            }
	private float distToPlayer(){
		 return Math.sqrt((player.getX() - x) * (player.getX() - x) + (player.getY() - y) * (player.getY() - y));
		 
	}
	private void move(){
		changeX(speed*Math.cos(Math.arcos(Math.abs(player.getX() - x)/distToPlayer())));
		changeY(speed*Math.sin(Math.arcos(Math.abs(player.getX() - x)/distToPlayer())));
	}
}
