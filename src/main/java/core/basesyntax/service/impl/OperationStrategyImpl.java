package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {

        return handlers.get(operation);
    }
}
