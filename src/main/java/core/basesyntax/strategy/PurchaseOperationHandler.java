package core.basesyntax.strategy;

import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit
                    + " in inventory. Avaliable quantity is " + currentQuantity);
        }
        int newQuantity = currentQuantity - quantity;
        inventory.put(fruit, newQuantity);
    }
}
