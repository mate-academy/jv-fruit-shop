package core.basesyntax.strategy;

import core.basesyntax.handler.Handler;
import core.basesyntax.models.FruitTransition;

public interface Strategy {
    Handler get(FruitTransition.Operation operation);
}
