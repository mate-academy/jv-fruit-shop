package core.basesyntax.service;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.Transaction;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {

    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public List<String> processDailyReport(List<Transaction> transactionsList) {
        for (Transaction transaction : transactionsList) {
            operationStrategy.getHandler(
                    transaction.getOperation()).applyOperation(transaction);
        }
        return StorageImpl.getStorage();
    }
}
