package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void proceed(Map<String, Integer> map, FruitTransaction transaction) {
        map.put(transaction.getFruit(), transaction.getQuantity());
    }
}
