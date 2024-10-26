package core.basesyntax.stategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction fruitTransaction,
                                 Map<String, Integer> inventory) {
        int currentBalance = inventory.getOrDefault(fruitTransaction.getFruit(), 0);
        int newBalance = currentBalance - fruitTransaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("Can`t complete purchase, not enough "
                    + fruitTransaction.getFruit());
        }
        inventory.put(fruitTransaction.getFruit(), newBalance);
    }
}
