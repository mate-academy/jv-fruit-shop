package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler chooseHandler(FruitTransaction transaction);
}
