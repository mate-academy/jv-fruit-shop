package core.basesyntax.strategy;

import core.basesyntax.operationHandler.OperationHandler;

public class DefaultOperationStrategy implements OperationStrategy{
    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return null;
    }
}
