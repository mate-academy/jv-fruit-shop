package core.basesyntax.action;

import core.basesyntax.model.Fruit;

public interface ActionHandler {
    int performAction(Fruit fruit, int amount);
}
