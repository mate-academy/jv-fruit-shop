package core.basesyntax.handler.impl;

import core.basesyntax.exceptions.NegativeFruitBalanceException;
import core.basesyntax.handler.TransactionHandler;
import java.util.Map;

public class PurchaseTransactionHandler implements TransactionHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void handleTransaction(Map<String, Integer> mapFruitQuantity, String key, int value) {
        Integer quantity = mapFruitQuantity.getOrDefault(key, DEFAULT_VALUE);

        if (quantity < 0) {
            throw new NegativeFruitBalanceException("Balance is negative");
        }
        mapFruitQuantity.put(key, mapFruitQuantity.getOrDefault(key, DEFAULT_VALUE) - value);
    }

}
