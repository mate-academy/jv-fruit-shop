package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class OperationStrategy {
    private final FruitTransaction.Operation operation;

    public OperationStrategy(FruitTransaction.Operation operation) {
        this.operation = operation;
    }

    public OperationHandler getHandler() {
        switch (operation) {
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
