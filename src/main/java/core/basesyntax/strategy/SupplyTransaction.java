package core.basesyntax.strategy;

import core.basesyntax.db.DatabaseImpl;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;

public class SupplyTransaction implements TransactionHandler {
    private DatabaseImpl databaseImpl = new DatabaseImpl();

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Fruit challenger = transaction.getFruit();
        if (databaseImpl.get(challenger) != null) {
            Integer newQuantity = databaseImpl.get(challenger) + transaction.getQuantity();
            databaseImpl.add(challenger, newQuantity);
            return true;
        }
        databaseImpl.add(challenger, transaction.getQuantity());
        return true;
    }
}
