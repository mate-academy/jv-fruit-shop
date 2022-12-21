package core.basesyntax.strategy.operationstrategy;

import core.basesyntax.model.FruitTransaction.Operation;
import java.util.Map;
import java.util.Optional;

public class OperationStrategy {
    private final Map<Operation, OperationCalculator> operationCalculatorsMap;

    public OperationStrategy(Map<Operation, OperationCalculator> operationCalculatorsMap) {
        this.operationCalculatorsMap = operationCalculatorsMap;
    }

    public OperationCalculator getOperationCalculator(Operation operation) {
        Optional<OperationCalculator> calculatorOptional = Optional
                .of(operationCalculatorsMap.get(operation));
        return calculatorOptional.orElseThrow(
                () -> new RuntimeException("Not supported operation type: " + operation));
    }
}
