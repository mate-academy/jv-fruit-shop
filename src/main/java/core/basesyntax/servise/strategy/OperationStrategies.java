package core.basesyntax.servise.strategy;

import core.basesyntax.servise.FruitTransaction;

public interface OperationStrategies {
    OperationService getOperationHandler(FruitTransaction fruitTransaction);
}
