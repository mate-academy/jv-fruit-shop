package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transaction) {
        for (int i = 0; i < transaction.getQuantity(); i++) {
             Storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
