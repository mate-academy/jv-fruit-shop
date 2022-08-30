package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface AmountHandler {
    int changeAmount(Fruit fruit, int amount);
}
