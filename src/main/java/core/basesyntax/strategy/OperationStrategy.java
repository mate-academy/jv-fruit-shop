package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public record OperationStrategy(
        Map<FruitTransaction.Operation, OperationsHandler> handlers) {

    public OperationsHandler getHandler(FruitTransaction fruitTransaction) {
        return handlers.get(fruitTransaction.getOperation());
    }
}
