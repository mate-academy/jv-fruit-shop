package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public record OperationStrategy(
        Map<FruitTransaction.Operation, OperationsHandler> handler) {

    public OperationsHandler getHandler(FruitTransaction fruitTransaction) {
        return handler.get(fruitTransaction.getOperation());
    }
}
