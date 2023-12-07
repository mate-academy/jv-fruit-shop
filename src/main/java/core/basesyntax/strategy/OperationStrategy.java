package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operationhandlers.OperationsHandler;

import java.util.Map;

public record OperationStrategy(
        Map<FruitTransaction.Operation, OperationsHandler> handlers) implements OperationOption {

    @Override
    public OperationsHandler getHandler(FruitTransaction fruitTransaction) {
        return handlers.get(fruitTransaction.getOperation());
    }
}
