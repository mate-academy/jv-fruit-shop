package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(Map<String, Integer> fruits, FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + transaction);
        }

        String fruit = transaction.getFruit();
        int current = fruits.getOrDefault(fruit, 0);
        int newQuantity = current - transaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("Not enough "
                    + fruit
                    + " in storage. "
                    + "Tried to purchase "
                    + transaction.getQuantity()
                    + ", but only "
                    + current
                    + " available.");
        }

        fruits.put(fruit, newQuantity);
    }
}
