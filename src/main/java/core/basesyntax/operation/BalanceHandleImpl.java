package core.basesyntax.operation;

import core.basesyntax.db.DataBaseFruit;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class BalanceHandleImpl implements Handler {
    @Override
    public int changeAmount(FruitRecordDto fruitRecord) {
        DataBaseFruit.storage.put(fruitRecord.getFruit(), fruitRecord.getQuantity());
        return fruitRecord.getQuantity();
    }
}
