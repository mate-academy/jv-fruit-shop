package core.basesyntax.service.operations.strategy;

import java.util.Map;

public interface IOperationHandler {
    void performOperation(String name, int quantity, Map<String, Integer> fruitQuantityMap);
}
