package strategy;

import java.util.Map;
import model.FruitTransaction;

public class TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionService> operationMap;

    public TransactionStrategy(Map<FruitTransaction.Operation, TransactionService> operationMap) {
        this.operationMap = operationMap;
    }

    public TransactionService getTransactionService(FruitTransaction.Operation operation) {
        TransactionService transactionService = operationMap.get(operation);
        if (transactionService == null) {
            throw new RuntimeException("No implementation for operation: "
                    + operation);
        }
        return transactionService;
    }
}
