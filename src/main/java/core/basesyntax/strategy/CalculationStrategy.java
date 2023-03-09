package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class CalculationStrategy {
    public CalculationService getCalculationServiceByLetter(FruitTransaction transaction) {
        switch (transaction.getOperation().getCode()) {
            case "b":
                return new Balance();
            case "s":
                return new Supply();
            case "p":
                return new Purchase();
            default:
                return new Return();
        }
    }
}
