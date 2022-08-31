package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void execute(Fruit fruit, Integer quantity) {
        if (!Storage.stock.containsKey(fruit)) {
            throw new RuntimeException(fruit + "s are out of stock");
        }
        if (Storage.stock.get(fruit) < quantity) {
            throw new RuntimeException("There is not enough fruit in stock!");
        }
        Storage.stock.put(fruit, Storage.stock.get(fruit) - quantity);
    }
}
