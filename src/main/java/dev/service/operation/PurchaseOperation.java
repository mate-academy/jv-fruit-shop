package dev.service.operation;

import dev.repository.FruitStore;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void update(FruitStore repository, String keyFruit, Integer value) {
        Integer prevQuantity = repository.selectQuantity(keyFruit);
        int newQuantity = prevQuantity - value;
        repository.updateQuantity(keyFruit, newQuantity);
    }
}
