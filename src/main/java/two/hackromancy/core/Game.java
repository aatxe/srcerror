package two.hackromancy.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;
import two.hackromancy.lwjgl.Window;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/8/13
 */
public class Game extends Window {
	public Game() throws LWJGLException {
		super(800, 600);
	}

	@Override
	public void init() {
		GL11.glClearColor(0.4f, 0.6f, 0.9f, 1.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void update(float ticksPassed) {
		// TODO: game logic
	}

	@Override
	public void render() {
		// TODO: rendering logic
		setupView();
	}

	public void setupView() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, 0, height, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glViewport(0, 0, width, height);
		GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
	}

	@Override
	public void dispose() {
		// TODO: clean dat shit up
	}
}
