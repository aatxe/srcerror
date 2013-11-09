package two.hackromancy.lwjgl;

import de.matthiasmann.twl.utils.PNGDecoder;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import two.hackromancy.util.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/9/13
 */
public class Sprite implements Renderable {
	private static int vbo = -1;
	private int texture = -1;
	PNGDecoder data;

	public Sprite(String path) throws IOException {
		File file = new File(path);
		data = new PNGDecoder(new FileInputStream(file));
		generateTexture();
	}

	@Override
	public void render() {
		try {
			render(0f, 0f);
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	public void render(float x, float y) throws IOException {
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
		GL11.glVertexPointer(2, GL11.GL_FLOAT, 2 * Constants.SIZEOF_FLOAT, 0);
		GL11.glTexCoordPointer(2, GL11.GL_FLOAT, 2 * Constants.SIZEOF_FLOAT, 0);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glTranslated(x, y, 0f);
		GL11.glScaled(data.getWidth(), data.getHeight(), 1);
		ByteBuffer buf = ByteBuffer.allocateDirect(4 * data.getHeight() * data.getWidth());
		data.decode(buf, data.getWidth() * 4, PNGDecoder.Format.RGBA);
		buf.flip();
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, data.getWidth(), data.getHeight(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buf);
		GL11.glDrawArrays(GL11.GL_QUADS, 0, 4);
		GL11.glPopMatrix();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}

	@Override
	public void dispose() {
		if (texture > 0)
			GL11.glDeleteTextures(texture);
	}

	public static void generateVBO() {
		IntBuffer vbof = BufferUtils.createIntBuffer(1);
		GL15.glGenBuffers(vbof);
		vbo = vbof.get(0);
	}

	private int generateTexture() {
		IntBuffer buf = BufferUtils.createIntBuffer(1);
		GL11.glGenTextures(buf);
		return buf.get(0);
	}
}
