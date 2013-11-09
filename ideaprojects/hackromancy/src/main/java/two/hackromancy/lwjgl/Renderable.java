package two.hackromancy.lwjgl;

/**
 * @author Aaron Weiss
 * @version 1.0
 * @since 11/8/13
 */
public interface Renderable {
	/**
	 * Renders this object.
	 */
	public void render();

	/**
	 * Cleans up this object.
	 */
	public void dispose();
}