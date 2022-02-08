package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class IncreaseOperationHandler implements OperationHandler {
    private static final Integer INITIAL_BALANCE = 0;

    @Override
    public int get(FruitRecord fruitRecord, Map<String, Integer> storage) {
        Optional<Integer> tmp = Optional.ofNullable(storage.get(fruitRecord.getFruit()));
        return tmp.orElse(INITIAL_BALANCE) + fruitRecord.getAmount();
    }
}
