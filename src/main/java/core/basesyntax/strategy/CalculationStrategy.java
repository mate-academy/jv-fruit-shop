package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class CalculationStrategy {
    public CalculationService getCalculationServiceByLetter(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                return new BalanceTransaction();
            case SUPPLY:
                return new SupplyTransaction();
            case PURCHASE:
                return new PurchaseTransaction();
            default:
                return new ReturnTransaction();
        }
    }
}
