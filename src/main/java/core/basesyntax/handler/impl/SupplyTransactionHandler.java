package core.basesyntax.handler.impl;

import core.basesyntax.handler.TransactionHandler;
import java.util.Map;

public class SupplyTransactionHandler implements TransactionHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void handleTransaction(Map<String, Integer> mapFruitQuantity, String key, int value) {
        mapFruitQuantity.put(key, mapFruitQuantity.getOrDefault(key, DEFAULT_VALUE) + value);
    }
}
