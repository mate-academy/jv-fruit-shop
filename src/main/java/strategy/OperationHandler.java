package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int operationHandler(FruitTransaction transaction, int storeQuantity);
}
