package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public class OperationStrategyImp implements OperationStrategy {
    @Override
    public Operation get(FruitTransaction.Operation operation,
                         Map<FruitTransaction.Operation, Operation> operationMap) {
        return operationMap.get(operation);
    }
}
