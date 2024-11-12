package core.basesyntax.service.action;

import core.basesyntax.model.Fruit;

public interface ActionHandler {
    void count(Fruit fruit, int amount);
}
