package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(Transaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Invalid quantity: " + transaction.getQuantity());
        }
        int quantity = transaction.getOperation() == Operation.BALANCE
                ? 0 : Storage.balance.get(transaction.getFruit());
        Storage.balance.put(transaction.getFruit(), quantity + transaction.getQuantity());
    }
}
