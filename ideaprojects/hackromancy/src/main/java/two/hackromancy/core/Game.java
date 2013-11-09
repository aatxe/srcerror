package two.hackromancy.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;
import two.hackromancy.lwjgl.Sprite;
import two.hackromancy.lwjgl.Window;

import java.io.IOException;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/8/13
 */
public class Game extends Window {
	private Sprite sprite;

	public Game() throws LWJGLException, IOException {
		super(800, 600);
		setTitle("Hackromancy");
		sprite = new Sprite("sprite.png");
	}

	@Override
	public void init() {
		clear();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
		GL11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Sprite.generateVBO();
	}

	@Override
	public void update(float ticksPassed) {
		// TODO: game logic
	}

	@Override
	public void render() {
		// TODO: rendering logic
		clear();
		setupView();
		sprite.render();
	}

	public void clear() {
		GL11.glClearColor(0.4f, 0.6f, 0.9f, 1.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
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
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
		GL11.glDisableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
	}
}
