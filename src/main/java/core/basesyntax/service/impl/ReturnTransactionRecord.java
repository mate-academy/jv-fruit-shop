package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileProcessing;
import core.basesyntax.service.FileProcessingImpl;

public class ReturnTransactionRecord implements TransactionRecord {
    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        FileProcessing fileProcessing = new FileProcessingImpl();
        fileProcessing.add(fruitTransaction);
    }
}
