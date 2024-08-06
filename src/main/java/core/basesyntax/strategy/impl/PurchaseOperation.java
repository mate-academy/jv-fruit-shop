package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Map<String, Integer> fruits = Storage.getFruits();
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentQuantity = fruits.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in stock");
        }
        fruits.put(fruit, currentQuantity - quantity);
    }
}
