package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.impl.BalanceCounterImpl;
import core.basesyntax.strategy.impl.PurchaseCounterImpl;
import core.basesyntax.strategy.impl.ReturnCounterImpl;
import core.basesyntax.strategy.impl.SupplyCounterImpl;

public class OperationStrategy {
    public static void getOperation(Transaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                new BalanceCounterImpl().apply(transaction);
                break;
            case PURCHASE:
                new PurchaseCounterImpl().apply(transaction);
                break;
            case SUPPLY:
                new SupplyCounterImpl().apply(transaction);
                break;
            case RETURN:
                new ReturnCounterImpl().apply(transaction);
                break;
            default:
                throw new RuntimeException("Unknown operation");
        }
    }
}
