package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface Operation {
    public void proceed(FruitTransaction fruitTransaction);
}
