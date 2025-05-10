package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;
import java.util.Map;

public interface OperationStrategy {
    void apply(Map<String, BigDecimal> inventory, FruitTransaction transaction);
}
