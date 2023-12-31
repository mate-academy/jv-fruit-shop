package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.operation.InputOperation;
import java.util.Map;

public class InputOperationStrategyImpl implements OperationStrategy {
    private Map<FruitOperation.Operation, InputOperation> inputOperationMap;

    public InputOperationStrategyImpl(
            Map<FruitOperation.Operation, InputOperation> inputOperationMap) {
        this.inputOperationMap = inputOperationMap;
    }

    @Override
    public InputOperation get(FruitOperation.Operation operation) {
        return inputOperationMap.get(operation);
    }
}
