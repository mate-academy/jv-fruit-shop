package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;

public interface IFruitStrategy<FruitTransaction> {
    void add(FruitTransaction fruitTransaction);
}
