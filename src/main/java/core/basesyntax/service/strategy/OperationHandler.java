package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import java.util.Map;

public interface OperationHandler {
    int get(FruitRecord fruitRecord, Map<String, Integer> storage);
}
