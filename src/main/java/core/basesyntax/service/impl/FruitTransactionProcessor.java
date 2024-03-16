package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.Storage;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;

public class FruitTransactionProcessor implements TransactionProcessor<FruitTransaction> {
    private final Storage storage;

    public FruitTransactionProcessor(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        storage.add(transaction.getProductType(), strategy(transaction));
    }

    private int strategy(FruitTransaction transaction) {
        if (OperationType.PURCHASE.getCode().equals(transaction.getTransactionType())) {
            return subtraction(transaction);
        } else {
            return add(transaction);
        }
    }

    private int subtraction(FruitTransaction transaction) {
        return -transaction.getTransactionValue();
    }

    private int add(FruitTransaction transaction) {
        return transaction.getTransactionValue();
    }
}
