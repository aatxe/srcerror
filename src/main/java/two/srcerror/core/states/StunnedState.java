package two.srcerror.core.states;

import two.srcerror.core.State;
import two.srcerror.core.nouns.Organism;
import two.srcerror.core.nouns.Organism.OrganismController;

public class StunnedState implements State {

    private Organism organism;
    private OrganismController controller;
    private final int modifier;
    private int remainingTicks;

    public StunnedState(Organism organism, OrganismController controller, int length, int modifier) {
        this.organism = organism;
        this.controller = controller;
        remainingTicks = length;
        this.modifier = modifier;
    }

    @Override
    public boolean isActive() {
        return (remainingTicks > 0);
    }

    @Override
    public void tick() {
        
        while(organism.velocity().getX() > 0) {
            controller.decelerateX();
        }
        while(organism.velocity().getY() > 0) {
            controller.decelerateY();
        }
        
        remainingTicks--;
    }
}
