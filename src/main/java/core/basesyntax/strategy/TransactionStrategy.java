package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceTransactionService;
import core.basesyntax.strategy.impl.PurchaseTransactionService;
import core.basesyntax.strategy.impl.ReturnTransactionService;
import core.basesyntax.strategy.impl.SupplyTransactionService;
import java.util.HashMap;
import java.util.Map;

public class TransactionStrategy {
    public Map<String,TransactionService> getTransactionService() {
        Map<String,TransactionService> transactionServiceMap = new HashMap<>();
        transactionServiceMap.put("b", new BalanceTransactionService());
        transactionServiceMap.put("p", new PurchaseTransactionService());
        transactionServiceMap.put("s", new SupplyTransactionService());
        transactionServiceMap.put("r", new ReturnTransactionService());
        return transactionServiceMap;
    }
}
