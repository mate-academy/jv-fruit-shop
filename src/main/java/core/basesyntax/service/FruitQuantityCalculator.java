package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitQuantityCalculator {
    void calculateQuantity(List<FruitTransaction> fruitTransactions);
}
