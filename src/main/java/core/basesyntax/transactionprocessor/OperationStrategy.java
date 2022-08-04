package core.basesyntax.transactionprocessor;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getImplementation(FruitTransaction transaction);
}
