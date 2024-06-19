package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> inventory) {
        int currentQuantity = inventory.getOrDefault(transaction.getFruit(), 0);
        int newQuantity = currentQuantity + transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException(
                    "Invalid quantity for fruit: " + transaction.getFruit());
        }
        inventory.put(transaction.getFruit(), newQuantity);
    }
}

