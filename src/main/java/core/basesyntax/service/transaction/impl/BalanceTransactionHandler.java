package core.basesyntax.service.transaction.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.TransactionHandler;

public class BalanceTransactionHandler implements TransactionHandler {

    @Override
    public void executeTransaction(FruitTransaction transaction) {
        if (transaction != null && transaction.getFruit() != null
                && transaction.getQuantity() >= 0) {
            Storage.addPair(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new InvalidDataException("Data cannot include null values!");
        }
    }
}
