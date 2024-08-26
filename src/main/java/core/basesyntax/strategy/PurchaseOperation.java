package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int quantityToPurchase = transaction.getQuantity();
        int currentQuantity = storage.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity - quantityToPurchase;
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough "
                    + fruit
                    + " in stock to complete the purchase.");
        }
        storage.put(fruit, newQuantity);
    }
}
