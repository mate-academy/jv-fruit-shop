package core.basesyntax.strategy;

import core.basesyntax.model.TransactionType;

public class TransactionHandlerProvider {
    public TransactionHandler getHandler(TransactionType type) {
        switch (type) {
            case BALANCE: {
                return new BalanceHandler();
            }
            case PURCHASE: {
                return new PurchaseHandler();
            }
            case RETURN: {
                return new ReturnHandler();
            }
            default: {
                return new SupplyHandler();
            }
        }
    }
}
