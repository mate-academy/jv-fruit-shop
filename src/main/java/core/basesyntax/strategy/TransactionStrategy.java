package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceTransactionService;
import core.basesyntax.strategy.impl.PurchaseTransactionService;
import core.basesyntax.strategy.impl.ReturnTransactionService;
import core.basesyntax.strategy.impl.SupplyTransactionService;

public class TransactionStrategy {
    public TransactionService getTransactionService(String transactionType) {
        switch (transactionType) {
            case "b":
                return new BalanceTransactionService();
            case "p":
                return new PurchaseTransactionService();
            case "s":
                return new SupplyTransactionService();
            case "r":
            default:
                return new ReturnTransactionService();
        }
    }
}
