package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitRecordDto;

public interface OperationHandler {
    void apply(FruitRecordDto fruitRecord);
}
