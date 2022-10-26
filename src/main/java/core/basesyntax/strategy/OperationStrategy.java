package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationSelector;
import java.util.Map;

public interface OperationStrategy {
    OperationSelector get(String type);

    void provideStrategyList(Map<Operation, OperationSelector> strategies);
}
