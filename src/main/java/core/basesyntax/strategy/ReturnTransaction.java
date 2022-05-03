package core.basesyntax.strategy;

import core.basesyntax.db.DatabaseImpl;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;

public class ReturnTransaction implements TransactionHandler {
    private DatabaseImpl storage = new DatabaseImpl();

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Fruit challenger = transaction.getFruit();
        if (storage.get(challenger) != null) {
            Integer newQuantity = storage.get(challenger) + transaction.getQuantity();
            storage.add(challenger, newQuantity);
            return true;
        }
        if (storage.get(challenger) == null) {
            throw new RuntimeException("Trying to return a fruit from another shop!");
        }
        return false;
    }
}
