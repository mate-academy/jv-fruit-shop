package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface CalculationService {
    void calculateAndStore(FruitTransaction transaction);
}
