package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.serviceimpl.operationhandlers.OperationHandler;

public interface TransactionStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
