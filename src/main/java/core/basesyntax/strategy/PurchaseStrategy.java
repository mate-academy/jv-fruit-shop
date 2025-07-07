package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseStrategy implements QuantityCalculationStrategy {
    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int startQuantity = Storage.STORAGE.get(fruit);
        int quantity = fruitTransaction.getQuantity();
        if (startQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + "in storage");
        }
        Storage.STORAGE.put(fruit, startQuantity - quantity);
    }
}
