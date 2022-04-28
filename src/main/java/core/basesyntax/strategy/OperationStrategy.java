package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class OperationStrategy {
    public OperationService getOperation(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case BALANCE:
                return new BalanceOperationService();
            case SUPPLY:
                return new SupplyOperationService();
            case PURCHASE:
                return new PurchaseOperationService();
            default:
                return new ReturnOperationService();
        }
    }

}
