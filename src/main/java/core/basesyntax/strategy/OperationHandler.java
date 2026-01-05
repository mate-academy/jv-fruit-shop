package core.basesyntax.strategy;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.Transaction;

public interface OperationHandler {
    public void handle(Transaction transaction, Inventory inventory);
}
