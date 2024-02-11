package core.basesyntax.strategy;

import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.BalanceTransactionService;
import core.basesyntax.service.impl.PurchaseTransactionService;
import core.basesyntax.service.impl.ReturnTransactionService;
import core.basesyntax.service.impl.SupplyTransactionService;

public class TransactionStrategy {
    public TransactionService getTransactionService(String transactionCode) {
        return switch (transactionCode) {
            case "b" -> new BalanceTransactionService();
            case "p" -> new PurchaseTransactionService();
            case "r" -> new ReturnTransactionService();
            case "s" -> new SupplyTransactionService();
            default -> throw new RuntimeException("Error: wrong transaction code!");
        };
    }
}
