package fruit.shop.strategy;

import fruit.shop.model.FruitTransaction;

public interface OperationHandler {
    void handleTransaction(FruitTransaction transaction);
}
