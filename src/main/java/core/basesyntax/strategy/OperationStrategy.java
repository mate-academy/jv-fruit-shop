package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler get(String type);

    void provideStrategyList(Map<Operation, OperationHandler> strategies);
}
