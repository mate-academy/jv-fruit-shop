package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyStrategy implements QuantityCalculationStrategy {
    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int startQuantity = Storage.STORAGE.get(fruit);
        int quantity = fruitTransaction.getQuantity();
        Storage.STORAGE.put(fruit, startQuantity + quantity);
    }
}
