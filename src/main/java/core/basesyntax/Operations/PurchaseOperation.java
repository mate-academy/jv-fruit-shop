package core.basesyntax.Operations;
import core.basesyntax.OpationStrategy.OperationHandler;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity, Map<String, Integer> storage) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) - quantity);  // Уменьшаем количество
    }
}
