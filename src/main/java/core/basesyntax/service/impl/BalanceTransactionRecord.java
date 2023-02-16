package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileProcessing;
import core.basesyntax.service.FileProcessingImpl;

public class BalanceTransactionRecord implements TransactionRecord {
    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        FileProcessing fileProcessing = new FileProcessingImpl();
        fileProcessing.add(fruitTransaction);
    }
}
