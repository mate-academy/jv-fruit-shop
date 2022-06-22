package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationStrategy {
    private final OperationHandler handler;

    public OperationStrategy(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE :
                handler = new BalanceHandler();
                break;
            case SUPPLY :
                handler = new SupplyHandler();
                break;
            case PURCHASE :
                handler = new PurchaseHandler();
                break;
            default :
                handler = new ReturnHandler();
        }
    }

    public OperationHandler getHandler() {
        return handler;
    }
}
