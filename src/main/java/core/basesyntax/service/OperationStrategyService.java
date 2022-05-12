package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public interface OperationStrategyService {
    OperationHandler get(FruitTransaction.Operation operation);
}
