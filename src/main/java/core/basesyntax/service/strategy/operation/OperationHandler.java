package core.basesyntax.service.strategy.operation;

import core.basesyntax.model.FruitRecordDto;

public interface OperationHandler {
    int getAmount(FruitRecordDto fruitRecord);
}
