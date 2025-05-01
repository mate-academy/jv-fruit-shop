package core.basesyntax.data.strategy;

import java.util.Map;

public interface OperationHandler {
    void apply(Map<String, Integer> inventory, String fruit, int quantity);
}
