package core.basesyntax;

import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.storage.Storage;
import java.util.List;

public class TransactionProcessor {
    private OperationStrategy operationStrategy;
    private Storage storage;

    public TransactionProcessor(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handleTransaction(transaction, storage.getFruitInventory());
        }
    }
}
