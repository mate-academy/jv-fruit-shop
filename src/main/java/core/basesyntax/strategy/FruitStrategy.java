package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.Operation;

public interface FruitStrategy {
    Operation proceed(FruitTransaction fruitTransaction);
}
