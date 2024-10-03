package strategy;

import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in inventory.");
        }

        int newQuantity = currentQuantity - quantity;

        if (newQuantity < 0) {
            throw new RuntimeException("Resulting quantity for " + fruit + " cannot be negative.");
        }

        inventory.put(fruit, newQuantity);
    }
}
