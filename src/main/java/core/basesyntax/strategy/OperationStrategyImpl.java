package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operations.OperationCompiler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationCompiler> operationCompilerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationCompiler> operationCompilerMap) {
        this.operationCompilerMap = operationCompilerMap;
    }

    @Override
    public OperationCompiler get(FruitTransaction.Operation operation) {
        return operationCompilerMap.get(operation);
    }
}
