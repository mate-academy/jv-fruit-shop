package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface QuantityCalculatorService {
    void calculate(List<FruitTransaction> fruitTransactions);
}
