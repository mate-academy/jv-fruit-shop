package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {

    public OperationHandler getHandlerForTransaction(FruitTransaction.Operation operation);
}
