package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class CalculationStrategy {
    public CalculationService getCalculationServiceByLetter(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                return new Balance();
            case SUPPLY:
                return new Supply();
            case PURCHASE:
                return new Purchase();
            default:
                return new Return();
        }
    }
}
