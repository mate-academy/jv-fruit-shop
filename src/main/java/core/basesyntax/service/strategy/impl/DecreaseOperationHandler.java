package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class DecreaseOperationHandler implements OperationHandler {
    @Override
    public int get(FruitRecord fruitRecord, Map<String, Integer> storage) {
        Optional<Integer> tmp = Optional.ofNullable(storage.get(fruitRecord.getFruit()));
        int amount = tmp.orElseThrow(() -> new RuntimeException("No such fruit was found."))
                - fruitRecord.getAmount();
        if (amount < 0) {
            throw new RuntimeException("Not enough fruit for sale.");
        }
        return amount;
    }
}
