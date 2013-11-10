package two.srcerror.core.states;

import two.srcerror.core.State;
import two.srcerror.core.nouns.Organism;
import two.srcerror.util.Constants;

public class RegenedState implements State {

    private Organism organism;
    private final int modifier;
    private int remainingTicks;

    public RegenedState(Organism organism, int length, int modifier) {
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
        organism.heal(modifier * Constants.REGEN_TICK_HEALTH);
        remainingTicks--;
    }
}
