package core.basesyntax.fruitshop.impl;

import core.basesyntax.fruitshop.db.Storage;
import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.strategy.OperationHandler;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        Map<String, Integer> storage = Storage.getInstance().getFruitStorage();
        if (!storage.containsKey(fruit) || storage.get(fruit) < quantity) {
            throw new IllegalStateException("Not enough " + fruit + " in stock for purchase.");
        }
        storage.put(fruit, storage.get(fruit) - quantity);
    }
}
