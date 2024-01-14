package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void proceed(Map<String, Integer> map, FruitTransaction transaction) {
        Integer newValue = map.get(transaction.getFruit()) + transaction.getQuantity();
        map.put(transaction.getFruit(), newValue);
    }
}
