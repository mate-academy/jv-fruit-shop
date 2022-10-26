package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationSelector;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final String CANT_FIND_OPERATOR_MESSAGE = "Can't find such operator ";
    private Map<Operation, OperationSelector> strategies;

    @Override
    public void provideStrategyList(Map<Operation, OperationSelector> strategies) {
        this.strategies = strategies;
    }

    @Override
    public OperationSelector get(String type) {
        Operation requiredOperation = null;
        for (Operation operation : Operation.values()) {
            if (operation.getOperation().equals(type)) {
                requiredOperation = operation;
            }
        }
        if (requiredOperation == null) {
            throw new RuntimeException(CANT_FIND_OPERATOR_MESSAGE + type);
        }
        return strategies.get(requiredOperation);
    }
}
