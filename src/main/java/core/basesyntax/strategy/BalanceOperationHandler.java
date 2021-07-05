package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        int currentBalance = transaction.getQuantity();
        Storage.fruits.put(new Fruit(transaction.getName()), currentBalance);
        return currentBalance;
    }
}
