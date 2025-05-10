package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.InputTransaction;
import java.util.Map;

public class InputOperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, InputTransaction> inputOperationMap;

    public InputOperationStrategyImpl(
            Map<FruitTransaction.Operation, InputTransaction> inputOperationMap) {
        this.inputOperationMap = inputOperationMap;
    }

    @Override
    public InputTransaction get(FruitTransaction.Operation operation) {
        return inputOperationMap.get(operation);
    }
}
