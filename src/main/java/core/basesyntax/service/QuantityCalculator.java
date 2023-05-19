package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface QuantityCalculator {
    List<String> calculate(List<FruitTransaction> fruitTransactions);
}
