package core.basesyntax.processing;

import core.basesyntax.handler.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawDataProcessor {
    private static final int ZERO_POSITION = 0;
    private static final int FIRST_POSITION = 1;
    private static final int SECOND_POSITION = 2;
    private final Map<String,TransactionHandler> transactionHandlerMap;

    public RawDataProcessor(Map<String, TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    public Map<String,Integer> process(List<List<String>> rawData) {
        Map<String, Integer> mapFruitQuantity = new HashMap<>();

        rawData.forEach(it -> {
            String type = it.get(ZERO_POSITION);
            String key = it.get(FIRST_POSITION);
            int value = Integer.parseInt(it.get(SECOND_POSITION));

            TransactionHandler handler = transactionHandlerMap.get(type);

            if (handler != null) {
                handler.handleTransaction(mapFruitQuantity, key, value);
            }
        });
        return mapFruitQuantity;
    }
}
