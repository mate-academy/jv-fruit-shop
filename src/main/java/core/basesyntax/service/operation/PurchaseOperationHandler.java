package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int amount = transaction.getAmount();
        int currentAmount = storage.getOrDefault(fruit, 0);

        if (currentAmount >= amount) {
            storage.put(fruit, currentAmount - amount);
        } else {
            throw new RuntimeException("Not enough fruit in storage: " + fruit);
        }
    }
}
