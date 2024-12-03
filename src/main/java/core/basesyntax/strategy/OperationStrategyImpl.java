package core.basesyntax.strategy;

import core.basesyntax.exceptions.OperationException;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;
import java.util.EnumMap;

public class OperationStrategyImpl implements OperationStrategy {
    private final EnumMap<FruitTransaction.Operation, OperationHandler>
            operationOperationHandlerEnumMap;

    public OperationStrategyImpl(EnumMap<FruitTransaction.Operation, OperationHandler>
                                         operationOperationHandlerEnumMap) {
        this.operationOperationHandlerEnumMap = operationOperationHandlerEnumMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        OperationHandler operationHandler = operationOperationHandlerEnumMap.get(operation);
        nullCheckInOperationHandler(operationHandler);
        return operationHandler;
    }

    private void nullCheckInOperationHandler(OperationHandler operationHandler) {
        if (operationHandler == null) {
            throw new OperationException("Operation is not found in the map!");
        }
    }
}
