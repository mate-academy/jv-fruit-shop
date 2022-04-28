package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationService {
    void proceed(FruitTransaction fruitTransaction);
}
