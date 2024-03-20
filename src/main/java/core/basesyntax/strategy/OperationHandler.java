package core.basesyntax.strategy;

import java.util.Map;

public interface OperationHandler {
    Map<String, Integer> calculateValue(String fruit, int quantity);
}
