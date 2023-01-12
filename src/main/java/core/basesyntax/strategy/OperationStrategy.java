package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public interface OperationStrategy {
    Map<FruitTransaction.Operation, OperationHandler> strategyMap = new HashMap<>();

    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
