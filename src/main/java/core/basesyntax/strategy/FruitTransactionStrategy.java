package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceTransaction;
import core.basesyntax.strategy.impl.PurchaseTransaction;
import core.basesyntax.strategy.impl.ReturnTransaction;
import core.basesyntax.strategy.impl.SupplyTransaction;
import java.util.HashMap;
import java.util.Map;

public class FruitTransactionStrategy {
    private static final Map<String, FruitTransactionHandler> transactionStrategyMap;

    static {
        transactionStrategyMap = new HashMap<>();
        transactionStrategyMap.put("b", new BalanceTransaction());
        transactionStrategyMap.put("s", new SupplyTransaction());
        transactionStrategyMap.put("p", new PurchaseTransaction());
        transactionStrategyMap.put("r", new ReturnTransaction());
    }

    public FruitTransactionHandler getTransaction(String transaction) {
        return transactionStrategyMap.get(transaction);
    }
}
