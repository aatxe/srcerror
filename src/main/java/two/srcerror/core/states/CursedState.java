package two.srcerror.core.states;

import two.srcerror.core.State;
import two.srcerror.core.nouns.Organism;
import two.srcerror.util.Constants;

public class CursedState implements State {

    private final Organism organism;
    private final int modifier;
    private int remainingTicks;
    
    public CursedState(Organism organism, int length) {
        this(organism, length, 15);
    }
    public CursedState(Organism organism, int length, int modifier) {
        this.organism = organism;
        remainingTicks = length;
        this.modifier = modifier; 
    }

    @Override
    public boolean isActive() {
        return (remainingTicks > 0);
    }

    @Override
    public void tick() {
        organism.hurt(modifier * curseFactor);
        remainingTicks--;
    }
}
