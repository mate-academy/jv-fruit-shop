package strategy;

import java.util.Map;
import model.FruitTransaction;

public class TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionService> operationMap;

    public TransactionStrategy(Map<FruitTransaction.Operation, TransactionService> operationMap) {
        this.operationMap = operationMap;
    }

    public TransactionService getTransactionService(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
