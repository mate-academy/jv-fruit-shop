package core.basesyntax;

import java.util.Map;

public interface OperationStrategy {
    void executeOperation(FruitTransaction transaction, Map<String, Integer> report);
}

