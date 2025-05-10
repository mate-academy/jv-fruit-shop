package dev.service;

import dev.service.operation.OperationHandler;
import dev.transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler toOperationHandler(FruitTransaction.Operation operation);
}
