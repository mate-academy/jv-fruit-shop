package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void calculate(Transaction transaction) {
        int oldQuantity = Storage.fruitsStorage.get(transaction.getFruit());
        Storage.fruitsStorage.put(transaction.getFruit(),oldQuantity + transaction.getQuantity());
    }
}
