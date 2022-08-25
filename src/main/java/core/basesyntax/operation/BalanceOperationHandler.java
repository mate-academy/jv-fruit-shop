package core.basesyntax.operation;

import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processingOperation(String fruit, int quantity, Map<String, Integer> values) {
        values.put(fruit, quantity);
    }
}
