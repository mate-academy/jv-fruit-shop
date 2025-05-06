package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Map;

public interface OperationStrategy {
    void executeOperation(FruitTransaction transaction, Map<String, Integer> report);

    OperationHandler getHandler(Operation operation);
}

