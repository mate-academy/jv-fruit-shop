package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationProcessMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                         operationProcessMap) {
        this.operationProcessMap = operationProcessMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation fruitOperation) {
        return operationProcessMap.get(fruitOperation);
    }
}
