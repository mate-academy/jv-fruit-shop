package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantitySupplied = fruitTransaction.getQuantity();
        int currentQuantity = storage.fruits.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + quantitySupplied;
        storage.fruits.put(fruit, newQuantity);
    }
}
