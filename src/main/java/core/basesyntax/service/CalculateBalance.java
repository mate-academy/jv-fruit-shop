package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CalculateBalance {
    void calculateBalance(List<FruitTransaction> fruitTransaction);
}
