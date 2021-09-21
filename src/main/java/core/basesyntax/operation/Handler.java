package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public interface Handler {
    int changeAmount(FruitRecordDto fruitRecord, Map<Fruit, Integer> storage);
}
