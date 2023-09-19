package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public class TransactionHandlerStrategyImp implements TransactionHandlerStrategy {
    @Override
    public TransactionHandler get(FruitTransaction.Operation operation,
                         Map<FruitTransaction.Operation, TransactionHandler> operationMap) {
        return operationMap.get(operation);
    }
}
