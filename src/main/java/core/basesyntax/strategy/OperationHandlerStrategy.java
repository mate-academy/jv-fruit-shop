package core.basesyntax.strategy;

import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;

public class OperationHandlerStrategy implements IOperationHandlerStrategy {
    private final Map<String, OperationHandler> listOperations;

    public OperationHandlerStrategy(Map<String, OperationHandler> listOperations) {
        this.listOperations = listOperations;
    }

    @Override
    public OperationHandler chooseOperation(String operation) {
        return listOperations.get(operation);
    }
}
