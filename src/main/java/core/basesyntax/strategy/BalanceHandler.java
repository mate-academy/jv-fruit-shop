package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceHandler implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Map<String, Integer> inventory) {
        String fruit = transaction.getFruit();
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + transaction.getQuantity();

        if (newQuantity < 0) {
            newQuantity = 0;
        }

        inventory.put(fruit, newQuantity);
    }
}
