package two.srcerror.core;

import two.srcerror.util.Vector;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/9/13
 */
public interface Noun {
	public boolean isAlive();
	public String identifier();
	public Vector position();
	public Vector velocity();
	public void tick();
	public Controller controller();
}
