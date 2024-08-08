package core.basesyntax;

import core.basesyntax.handler.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
    }
}
