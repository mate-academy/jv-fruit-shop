package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void calculate(Transaction transaction) {
        int oldQuantity = Storage.fruitsStorage.get(transaction.getFruit());
        Storage.fruitsStorage.put(transaction.getFruit(), transaction.getQuantity() + oldQuantity);
    }
}
