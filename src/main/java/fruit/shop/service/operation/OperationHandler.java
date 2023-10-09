package fruit.shop.service.operation;

import fruit.shop.service.FruitTransaction;

public interface OperationHandler {
    String getOperation (FruitTransaction.Operation code);
}
