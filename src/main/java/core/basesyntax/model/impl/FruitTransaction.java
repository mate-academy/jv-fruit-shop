package core.basesyntax.model.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.Transaction;

public class FruitTransaction extends Transaction {
    public FruitTransaction(OperationType operationType, String productType, int transactionValue) {
        super(operationType, productType, transactionValue);
    }
}
