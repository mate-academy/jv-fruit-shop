package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface CalculateStrategy {
    public OperationHandler getHandler(FruitTransaction transaction);
}
