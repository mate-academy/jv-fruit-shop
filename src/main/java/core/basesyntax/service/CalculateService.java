package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CalculateService {
    void calculate(List<FruitTransaction> fruitTransactions);
}
