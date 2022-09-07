package core.basesyntax.service.activities;

import core.basesyntax.model.Fruit;

public interface Purchase {
    void take(Fruit fruit, Integer amount);
}
