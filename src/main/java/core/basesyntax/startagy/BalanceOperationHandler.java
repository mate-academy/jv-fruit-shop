package core.basesyntax.startagy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
        return transaction.getQuantity();
    }
}
