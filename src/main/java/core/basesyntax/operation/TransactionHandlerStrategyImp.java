package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public class TransactionHandlerStrategyImp implements TransactionHandlerStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> operationMap;

    public TransactionHandlerStrategyImp(Map<FruitTransaction.Operation,
            TransactionHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
