package core.basesyntax.strategy;

import core.basesyntax.service.operations.IOperationHandler;
import java.util.Map;

public class OperationHandlerStrategy implements IOperationHandlerStrategy {
    private final Map<String, IOperationHandler> listOperations;

    public OperationHandlerStrategy(Map<String, IOperationHandler> listOperations) {
        this.listOperations = listOperations;
    }

    @Override
    public IOperationHandler chooseOperation(String operation) {
        return listOperations.get(operation);
    }
}
