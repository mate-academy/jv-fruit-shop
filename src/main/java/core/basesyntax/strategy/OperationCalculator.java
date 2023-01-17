package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationCalculator {
    int calculate(FruitTransaction fruitTransaction, Map<String, Integer> fruitsMap);
}
