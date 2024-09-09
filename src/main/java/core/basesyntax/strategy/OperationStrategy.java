package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public interface OperationStrategy {
    void applyOperation(Operation operation, String fruit,
                        int quantity, Map<String, Integer> storage);
}
