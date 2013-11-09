package two.hackromancy.lwjgl;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

import java.nio.IntBuffer;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/9/13
 */
public class Sprite implements Renderable {
	private int vbo = -1, texture = -1;

	public Sprite() {
		vbo = createVBO();
	}

	@Override
	public void render() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void dispose() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	private int createVBO() {
		IntBuffer vbof = BufferUtils.createIntBuffer(1);
		GL15.glGenBuffers(vbof);
		return vbof.get(0);
	}

	private int generateTexture() {
		IntBuffer buf = BufferUtils.createIntBuffer(1);
		GL11.glGenTextures(buf);
		return buf.get(0);
	}
}
