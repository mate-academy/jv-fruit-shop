package core.basesyntax.startagy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class AddOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        int previousValue = Storage.fruits.get(transaction.getFruit());
        int newValue = previousValue + transaction.getQuantity();
        Storage.fruits.put(transaction.getFruit(), newValue);
        return newValue;
    }
}
