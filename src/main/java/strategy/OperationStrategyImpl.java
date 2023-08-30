package strategy;

import model.FruitTransaction;
import java.util.Map;
import service.operation.OperationTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,
            OperationTransaction> operationOperationTransactionMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationTransaction> operationOperationTransactionMap) {
        this.operationOperationTransactionMap = operationOperationTransactionMap;
    }

    @Override
    public OperationTransaction getOperation(FruitTransaction.Operation operation) {
        return operationOperationTransactionMap.get(operation);
    }
}
