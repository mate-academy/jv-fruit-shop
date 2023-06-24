package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.Handler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, Handler> operationStrategyHashMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, Handler>
                                         operationStrategyHashMap) {
        this.operationStrategyHashMap = operationStrategyHashMap;
    }

    @Override
    public Handler get(FruitTransaction.Operation operation) {
        return operationStrategyHashMap.get(operation);
    }
}
