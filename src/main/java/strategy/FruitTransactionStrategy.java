package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.operation.OperationHandler;

public class FruitTransactionStrategy implements TransactionStrategy {
    private Map<FruitTransaction.Operation, OperationHandler<String, Integer>> operationsMap;

    public FruitTransactionStrategy(Map<FruitTransaction.Operation,
            OperationHandler<String,Integer>> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationsMap.get(operation);
    }
}
