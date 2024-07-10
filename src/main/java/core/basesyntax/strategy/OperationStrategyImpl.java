package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationToHandler;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationToHandler) {
        this.operationToHandler = operationToHandler;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operationToHandler.get(operation);
    }

}
