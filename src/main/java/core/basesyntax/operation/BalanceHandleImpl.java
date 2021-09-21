package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class BalanceHandleImpl implements Handler {
    @Override
    public int changeAmount(FruitRecordDto fruitRecord, Map<Fruit, Integer> storage) {
        storage.put(fruitRecord.getFruit(), 0);
        return fruitRecord.getQuantity();
    }
}
