package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationStrategy {
    void apply(FruitTransaction tx, Map<String, Integer> storage);
}
