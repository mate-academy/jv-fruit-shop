package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> inventory) {
        String fruit = transaction.getFruit();
        int current = inventory.getOrDefault(fruit, 0);
        int newQuantity = current - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in stock for purchase");
        }
        inventory.put(fruit, newQuantity);
    }
}
