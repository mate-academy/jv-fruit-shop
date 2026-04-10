package core.basesyntax.service;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void process(FruitTransaction tx, Map<String, Integer> storage) {
        storage.put(
                tx.getFruit(),
                storage.getOrDefault(tx.getFruit(), 0) - tx.getQuantity()
        );
    }
}
