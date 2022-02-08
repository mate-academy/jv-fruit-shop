package core.basesyntax.operation;

import core.basesyntax.model.FruitRecordDto;
public interface OperationHandler {
    int apply(FruitRecordDto fruitRecord);
}
