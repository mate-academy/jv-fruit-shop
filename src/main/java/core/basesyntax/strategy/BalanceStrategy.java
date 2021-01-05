package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transaction) {
        Storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
    }
}
