package core.basesyntax.processing;

import core.basesyntax.enums.Operation;
import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.handler.impl.BalanceTransactionHandler;
import core.basesyntax.handler.impl.PurchaseTransactionHandler;
import core.basesyntax.handler.impl.ReturnTransactionHandler;
import core.basesyntax.handler.impl.SupplyTransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawDataProcessor {
    private final List<List<String>> rawData;
    private final Map<String, TransactionHandler> transactionHandlerMap;

    public RawDataProcessor(List<List<String>> rawData) {
        this.rawData = rawData;
        this.transactionHandlerMap = Map.of(
                Operation.BALANCE.getCode(), new BalanceTransactionHandler(),
                Operation.SUPPLY.getCode(), new SupplyTransactionHandler(),
                Operation.PURCHASE.getCode(), new PurchaseTransactionHandler(),
                Operation.RETURN.getCode(), new ReturnTransactionHandler()

        );
    }

    public Map<String, Integer> process() {
        Map<String, Integer> mapFruitQuantity = new HashMap<>();

        rawData.forEach(it -> {
            String type = it.get(0);
            String key = it.get(1);
            int value = Integer.parseInt(it.get(2));

            TransactionHandler handler = transactionHandlerMap.get(type);

            if (handler != null) {
                handler.handleTransaction(mapFruitQuantity, key, value);
            }
        });

        return mapFruitQuantity;
    }
}
