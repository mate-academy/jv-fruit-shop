package core.basesyntax.strategy;

import core.basesyntax.db.DatabaseImpl;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;

public class PurchaseTransaction implements TransactionHandler {
    private DatabaseImpl storage = new DatabaseImpl();

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
