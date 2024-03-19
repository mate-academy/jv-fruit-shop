package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    private final Map<String, Integer> fruitStore;

    public PurchaseHandler(Map<String, Integer> fruitStore) {
        this.fruitStore = fruitStore;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Integer currentQuantity = fruitStore.get(fruit);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in the store");
        }

        fruitStore.put(fruit, currentQuantity - quantity);
    }
}
