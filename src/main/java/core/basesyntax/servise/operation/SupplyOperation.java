package core.basesyntax.servise.operation;

import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Map<String, Integer> storage) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }
}
