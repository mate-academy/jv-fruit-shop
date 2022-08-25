package core.basesyntax.operation;

import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processingOperation(String fruit, int quantity, Map<String, Integer> values) {
        Integer amount = values.get(fruit) + quantity;
        values.put(fruit, amount);
    }
}
