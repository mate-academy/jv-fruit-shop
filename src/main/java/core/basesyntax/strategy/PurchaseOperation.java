package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> map) {
        if (transaction == null || map == null) {
            throw new RuntimeException("Transaction and map cannot be null");
        }

        if (transaction.getFruit().isEmpty()) {
            throw new RuntimeException("Fruit name cannot be null");
        }

        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }

        String fruit = transaction.getFruit();

        if (!map.containsKey(fruit)) {
            throw new RuntimeException("Fruit not found in storage");
        }

        int quantityNow = map.get(fruit);
        int purchasedQuantity = transaction.getQuantity();
        int countLeft = quantityNow - purchasedQuantity;

        if (countLeft < 0) {
            throw new RuntimeException("Not enough fruits" + fruit);
        }

        map.put(transaction.getFruit(), countLeft);
    }
}
