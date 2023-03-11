package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;

public class TransactionStrategy {
    public Transaction getTransaction(StorageTransaction transaction) {
        switch (transaction.getTypeActivity()) {
            case BALANCE:
                return new BalanceTransaction();
            case RETURN:
                return new ReturnTransaction();
            case PURCHASE:
                return new PurchaseTransaction();
            default:
                return new SupplyTransaction();
        }
    }
}
