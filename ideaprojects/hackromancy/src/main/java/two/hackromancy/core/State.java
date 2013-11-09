package two.hackromancy.core;

public abstract class State {
    //should take organism when construced
    public abstract boolean isRunning();

    public abstract void run();

}
