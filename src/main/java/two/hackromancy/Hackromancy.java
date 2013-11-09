package two.hackromancy;

import org.lwjgl.LWJGLException;
import two.hackromancy.core.Game;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/8/13
 */
public class Hackromancy {
	public static void main(String[] args) {
		try {
			Game game = new Game();
			game.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
