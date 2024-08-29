package core.basesyntax.handler;

import java.util.Map;

public interface TransactionHandler {
    void handleTransaction(Map<String, Integer> mapFruitQuantity, String key, int value);

}
