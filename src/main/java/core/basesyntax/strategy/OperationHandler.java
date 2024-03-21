package core.basesyntax.strategy;

import java.util.Map;

public interface OperationHandler {
    Map<String, Integer> handle(String fruit, int quantity);
}
