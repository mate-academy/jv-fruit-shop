package core.basesyntax.strategy;

import java.util.Map;

public interface OperationHandler {
    void apply(String fruit, int quantity, Map<String, Integer> storage);
}
