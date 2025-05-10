package core.basesyntax.strategy;

import core.basesyntax.servise.FruitTransaction;

public interface OperationStrategy {
    OperationService getOperationHandler(FruitTransaction fruitTransaction);
}
