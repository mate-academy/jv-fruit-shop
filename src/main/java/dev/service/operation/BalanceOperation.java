package dev.service.operation;

import dev.repository.FruitStore;

public class BalanceOperation implements OperationHandler {
    @Override
    public void update(FruitStore repository, String keyFruit, Integer value) {
        repository.updateQuantity(keyFruit, value);
    }
}
