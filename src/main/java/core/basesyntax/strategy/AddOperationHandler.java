package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class AddOperationHandler implements OperationHandler {

    @Override
    public int apply(Transaction transaction) {
        int previousValue = Storage.storage.get(transaction.getFruit());
        int newValue = previousValue + transaction.getQuantity();
        Storage.storage.put(transaction.getFruit(), newValue);
        return newValue;
    }
}
