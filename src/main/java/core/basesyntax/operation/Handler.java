package core.basesyntax.operation;

import core.basesyntax.model.FruitRecordDto;
public interface Handler {
    int changeAmount(FruitRecordDto fruitRecord);
}
