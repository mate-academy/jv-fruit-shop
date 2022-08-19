package services.operation;

import services.transaction.model.ProductTransaction;

public interface OperationHandler {
    void handle(ProductTransaction transaction);
}
