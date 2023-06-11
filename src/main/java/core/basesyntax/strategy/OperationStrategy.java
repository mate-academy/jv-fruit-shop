package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void operationStrategy(FruitTransaction transaction, FruitStorage fruitStorage);
}
