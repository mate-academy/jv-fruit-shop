package core.basesyntax.dao;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
