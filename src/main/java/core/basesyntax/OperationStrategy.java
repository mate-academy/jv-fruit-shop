package core.basesyntax;

import core.basesyntax.handler.OperationHandler;

import java.util.Map;

public interface OperationStrategy {
    public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlers();
}
