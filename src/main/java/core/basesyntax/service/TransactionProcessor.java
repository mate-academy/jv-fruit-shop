package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;

public class TransactionProcessor {
    private Storage storage;
    private HashMap<FruitTransaction.Operation, OperationStrategy> operationMap;

    public TransactionProcessor(Storage storage, HashMap<FruitTransaction.Operation,
            OperationStrategy> operationMap) {
        this.storage = storage;
        this.operationMap = operationMap;
    }

    public void processTransaction(FruitTransaction transaction) {
        operationMap.get(transaction.getOperation())
                .processTransaction(transaction,storage);
    }
}
