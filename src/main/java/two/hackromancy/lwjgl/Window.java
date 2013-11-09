package two.hackromancy.lwjgl;

import com.google.common.base.Stopwatch;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.Util;
import two.hackromancy.util.Constants;

import java.util.concurrent.TimeUnit;

/**
 * @author Aaron
 * @version 1.0
 * @since 11/8/13
 */
public abstract class Window {
	protected final int width, height;
	protected boolean isRunning;
	private int fps;
	private int frameCount;

	public Window(int width, int height) throws LWJGLException {
		this.width = width;
		this.height = height;
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.create();
		Keyboard.create();
	}

	public void setTitle(String title) {
		Display.setTitle(title);
	}

	public abstract void init();

	public abstract void update(float ticksPassed);

	public abstract void render();

	public abstract void dispose();

	public void open() {
		init();
		Util.checkGLError();
		Display.update();
		isRunning = true;
		run();
	}

	protected void run() {
		Stopwatch fpsTimer = new Stopwatch();
		Stopwatch updateTimer = new Stopwatch();
		fpsTimer.start();
		while (isRunning && !Display.isCloseRequested()) {
			this.update((updateTimer.elapsed(TimeUnit.MILLISECONDS) / 1000f) * Constants.TICKS_PER_SECOND);
			updateTimer.reset();
			updateTimer.start();
			this.render();
			frameCount++;
			if (fpsTimer.elapsed(TimeUnit.SECONDS) >= 1) {
				fps = frameCount;
				frameCount = 0;
				fpsTimer.reset();
				fpsTimer.start();
			}
			Util.checkGLError();
			Display.update();
			Display.sync(60);
		}
		try {
			updateTimer.stop();
			fpsTimer.stop();
		} catch (IllegalStateException e) {}
		dispose();
		Display.destroy();
	}

	public int getFramesPerSecond() {
		return fps;
	}

	public void close() {
		isRunning = false;
	}
}
