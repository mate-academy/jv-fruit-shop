package core.basesyntax.strategy;

import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.BalanceTransactionService;
import core.basesyntax.service.impl.PurchaseTransactionService;
import core.basesyntax.service.impl.ReturnTransactionService;
import core.basesyntax.service.impl.SupplyTransactionService;
import java.util.Map;

public class TransactionStrategy {
    public TransactionService getTransactionService(String transactionCode) {
        return Map.of("b", new BalanceTransactionService(),
                "p", new PurchaseTransactionService(),
                "r", new ReturnTransactionService(),
                "s", new SupplyTransactionService())
                .get(transactionCode);
    }
}
