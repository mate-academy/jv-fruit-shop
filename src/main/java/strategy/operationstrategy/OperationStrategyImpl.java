package strategy.operationstrategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.transactionhandlers.TransactionHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> operationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, TransactionHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
