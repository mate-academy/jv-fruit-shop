package strategy;

import java.util.Map;
import model.FruitTransaction;
import service.operation.TransactionHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,
            TransactionHandler> operationOperationTransactionMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> operationOperationTransactionMap) {
        this.operationOperationTransactionMap = operationOperationTransactionMap;
    }

    @Override
    public TransactionHandler getHandler(FruitTransaction.Operation operation) {
        return operationOperationTransactionMap.get(operation);
    }
}
