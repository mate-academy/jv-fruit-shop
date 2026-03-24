package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction tx) {
        int currentQuantity = storage.getOrDefault(tx.getFruit(), 0);

        if (currentQuantity < tx.getQuantity()) {
            throw new RuntimeException("Not enough fruit: " + tx.getFruit());
        }
        storage.put(tx.getFruit(), currentQuantity - tx.getQuantity());
    }
}
