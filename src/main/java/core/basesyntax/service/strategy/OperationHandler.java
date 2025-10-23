package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void apply(Map<String, Integer> fruits, FruitTransaction transaction);
}
