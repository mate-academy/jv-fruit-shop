package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

@FunctionalInterface
public interface OperationHandler {
    void proccessTransaction(FruitTransaction transaction);
}
