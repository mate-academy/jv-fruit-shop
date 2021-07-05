package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getName());
        int currentQuantity = Storage.getFruits().getOrDefault(fruit, 0);
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (currentQuantity - newQuantity < 0) {
            throw new RuntimeException("The store does`t have the required amount of fruits");
        }
        Storage.getFruits().put(fruit, newQuantity);
        return newQuantity;
    }
}
