package core.basesyntax.strategy;

import core.basesyntax.model.MovementType;

public interface Strategy {
    GoodHandler getHandlerForMovement(MovementType type);
}
