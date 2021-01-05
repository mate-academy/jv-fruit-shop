package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction is empty");
        }
        Storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
    }
}
