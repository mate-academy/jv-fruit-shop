package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public int apply(Transaction transaction) {
        int previousValue = Storage.storage.get(transaction.getFruit());
        int newValue = previousValue - transaction.getQuantity();
        if (newValue < 0) {
            System.out.println("Don't have enough fruits, giving you all that I have - "
                    + previousValue + " " + transaction.getFruit().getName() + "s");
            newValue = 0;
        }
        Storage.storage.put(transaction.getFruit(), newValue);
        return newValue;
    }
}
