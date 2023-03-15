package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitCalculator {
    public void calculateTotalQuantity(List<FruitTransaction> transactions);
}
