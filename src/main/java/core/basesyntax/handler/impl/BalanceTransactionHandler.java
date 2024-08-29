package core.basesyntax.handler.impl;

import core.basesyntax.handler.TransactionHandler;
import java.util.Map;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void handleTransaction(Map<String, Integer> mapFruitQuantity, String key, int value) {
        mapFruitQuantity.put(key, value);
    }

}
