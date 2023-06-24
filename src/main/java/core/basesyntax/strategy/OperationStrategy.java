package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction fruitTransaction);
}
