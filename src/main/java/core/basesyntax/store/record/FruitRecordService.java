package core.basesyntax.store.record;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;

public interface FruitRecordService {
    FruitRecord createNewFruitRecord(Fruit fruit, OperationType operationType);
}
