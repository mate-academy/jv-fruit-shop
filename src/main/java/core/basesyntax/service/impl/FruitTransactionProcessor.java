package core.basesyntax.service.impl;

import core.basesyntax.model.Storage;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;

public class FruitTransactionProcessor implements TransactionProcessor<FruitTransaction> {

    @Override
    public void process(FruitTransaction transaction) {
        Storage.add(transaction.getProductType(), strategy(transaction));
    }

    public int strategy(FruitTransaction transaction) {
        return switch (transaction.getTransactionType()) {
            case PURCHASE -> subtraction(transaction);
            case RETURN, BALANCE, SUPPLY -> add(transaction);
        };
    }

    private int subtraction(FruitTransaction transaction) {
        return -transaction.getTransactionValue();
    }

    private int add(FruitTransaction transaction) {
        return transaction.getTransactionValue();
    }
}
