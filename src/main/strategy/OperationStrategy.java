package main.strategy;

import main.model.ProductTransaction;
import main.service.Operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(ProductTransaction.Operation operation);
}
