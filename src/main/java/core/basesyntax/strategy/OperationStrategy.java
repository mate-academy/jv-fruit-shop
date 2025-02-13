package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public interface OperationStrategy {
    void strategy(FruitTransaction fruitTransaction, FruitStorage storage);
}
