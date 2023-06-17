package fruit.shop.service.strategy;

import fruit.shop.model.FruitTransaction;

public interface OperationStrategy {
    void handleTransaction(FruitTransaction transaction);
}
