package core.basesyntax;

import java.util.Map;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int currentQuantity = storage.getOrDefault(fruit, 0);
        storage.put(fruit, currentQuantity + quantity);
    }
}
