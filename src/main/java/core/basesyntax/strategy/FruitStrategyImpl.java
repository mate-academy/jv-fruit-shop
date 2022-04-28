package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.Operation;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, Operation> operationOperationHandlerMap;

    public FruitStrategyImpl(
            Map<FruitTransaction.Operation, Operation> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public Operation proceed(FruitTransaction fruitTransaction) {
        return operationOperationHandlerMap.get(
                fruitTransaction.getOperation()).proceed(fruitTransaction);
    }
}
