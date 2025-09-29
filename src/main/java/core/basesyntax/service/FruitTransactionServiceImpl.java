package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

public class FruitTransactionServiceImpl implements FruitTransactionService {

    @Override
    public void createTransaction(Operation operation, String fruit, int quantity) {
        FruitTransaction fruitTransaction = FruitTransaction.create(operation, fruit, quantity);
        Storage.addRecord(fruitTransaction);
    }
}
