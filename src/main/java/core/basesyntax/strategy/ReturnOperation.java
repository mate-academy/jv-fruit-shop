package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityReturned = fruitTransaction.getQuantity();
        int currentQuantity = storage.getFruits().getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + quantityReturned;
        storage.getFruits().put(fruit, newQuantity);
    }
}
