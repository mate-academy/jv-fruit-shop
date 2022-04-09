package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public interface TransactionStrategy {
    OperationHandler getActivity(FruitTransaction.Operation operation);
}
