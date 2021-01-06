package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transaction) {
        Storage.getFruits().merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}

