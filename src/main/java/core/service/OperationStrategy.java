package core.service;

import core.model.FruitTransaction;
import core.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
