package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Calculator {
    void calculate(List<FruitTransaction> fruitTransactions);
}
