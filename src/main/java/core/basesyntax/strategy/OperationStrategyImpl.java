package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationProcess> operationProcessMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationProcess>
                                         operationProcessMap) {
        this.operationProcessMap = operationProcessMap;
    }

    @Override
    public OperationProcess get(FruitTransaction.Operation fruitOperation) {
        return operationProcessMap.get(fruitOperation);
    }
}
