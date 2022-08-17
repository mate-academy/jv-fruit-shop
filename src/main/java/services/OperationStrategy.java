package services;

import services.operation.OperationHandler;
import services.transaction.model.ProductTransaction;

public interface OperationStrategy {
    OperationHandler get(ProductTransaction.Operation operation);
}
