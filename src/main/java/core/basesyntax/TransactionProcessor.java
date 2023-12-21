package core.basesyntax;

import core.basesyntax.operationStrategy.OperationStrategy;

import java.util.List;

public class TransactionProcessor {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public TransactionProcessor(Storage storage) {
        this.storage = storage;
        this.operationStrategy = new OperationStrategy();
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation()).handleOperation(transaction, storage);
        }
    }
}

//TransactionProcessor is a service that should accept list of transactions and process them all
