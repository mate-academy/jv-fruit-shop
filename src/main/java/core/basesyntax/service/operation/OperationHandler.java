package core.basesyntax.service.operation;

import java.util.Map;

public interface OperationHandler {
    void apply(Map<String, Integer> fruitQuantityMap, String fruitName, int quantity);
}
