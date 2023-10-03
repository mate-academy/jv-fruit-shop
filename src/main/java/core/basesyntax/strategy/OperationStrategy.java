package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationStrategy {
    Map<FruitTransaction.Operation, OperationHandler> createOperationHandlerMap();

    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
