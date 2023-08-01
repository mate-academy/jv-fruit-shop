package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategyService {
    OperationHandlerService getHandler(FruitTransaction.Operation operation);
}
