package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationStrategy {
    void applyOperation(FruitTransaction.Operation operation, String fruit,
                        int quantity, Map<String, Integer> storage);
}
