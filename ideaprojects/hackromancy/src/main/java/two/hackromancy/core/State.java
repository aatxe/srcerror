package two.hackromancy.core;

public abstract class State {
    //should take player when construced
    public abstract boolean isRunning();

    public abstract void run();

}
