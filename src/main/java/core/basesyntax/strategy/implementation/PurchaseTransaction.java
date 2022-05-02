package core.basesyntax.strategy.implementation;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseTransaction implements TransactionHandler {
    private Storage storage = new Storage();

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Fruit challenger = transaction.getFruit();
        if (storage.get(challenger) != null) {
            Integer newQuantity = storage.get(challenger) - transaction.getQuantity();
            storage.add(challenger, newQuantity);
            return true;
        }
        if (storage.get(challenger) == null) {
            throw new RuntimeException("Trying to purchase non-existing fruit!");
        }
        if (storage.get(challenger) != null
                    && storage.get(challenger) < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in a shop!");
        }
        return false;
    }
}
