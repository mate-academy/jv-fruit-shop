package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface QuantityCalculatorService {
    void calculate(List<FruitTransaction> fruitTransactions);
}
