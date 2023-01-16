package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    int get(FruitTransaction fruitRecord, Map<String, Integer> fruits);
}
