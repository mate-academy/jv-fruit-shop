package core.basesyntax.store.record;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;

public class FruitRecordServiceImpl implements FruitRecordService {
    @Override
    public FruitRecord createNewFruitRecord(Fruit fruit, OperationType operationType) {
        return new FruitRecord(fruit, operationType);
    }
}
