package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;

public interface TransactionStrategy {

    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
