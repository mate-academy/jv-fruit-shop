package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ServiceStrategy {
    public OperationHandler getServiceStrategy(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE :
                return new BalanceHandler();
            case SUPPLY :
                return new SupplyHandler();
            case PURCHASE :
                return new PurchaseHandler();
            default :
                return new ReturnHandler();
        }
    }
}
