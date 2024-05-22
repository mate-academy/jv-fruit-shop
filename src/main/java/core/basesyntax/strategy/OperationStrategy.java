package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    public OperationHandler chooseHandler(FruitTransaction transaction);
}
