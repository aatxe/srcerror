package two.hackromancy.core;

public abstract class State {

    public abstract boolean isRunning();

    public abstract void run();

    public abstract void setPlayer(Player p);

    public abstract Player getPlayer();
}