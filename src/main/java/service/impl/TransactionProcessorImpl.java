package service.impl;

import model.FruitTransaction;
import service.TransactionProcessor;

public class TransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        fruitTransaction.operation().accept(fruitTransaction);
    }
}
