package core.basesyntax.service.strategy.operation;

import core.basesyntax.model.FruitRecord;

import java.util.Map;

public interface OperationHandler {
    int getAmount(FruitRecord fruitRecord, Map<String, Integer> fruitStorage);
}
