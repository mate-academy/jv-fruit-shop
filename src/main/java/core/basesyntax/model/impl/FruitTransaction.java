package core.basesyntax.model.impl;

import core.basesyntax.model.Transaction;

public class FruitTransaction extends Transaction {
    public FruitTransaction(String transactionType, String productType, int transactionValue) {
        super(transactionType, productType, transactionValue);
    }
}
