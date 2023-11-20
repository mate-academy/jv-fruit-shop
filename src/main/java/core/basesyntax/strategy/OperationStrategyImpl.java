package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationPerformer> operationPerformerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationPerformer> operationPerformerMap) {
        this.operationPerformerMap = operationPerformerMap;
    }

    @Override
    public OperationPerformer get(FruitTransaction transaction) {
        return operationPerformerMap.get(transaction.getOperation());
    }
}
