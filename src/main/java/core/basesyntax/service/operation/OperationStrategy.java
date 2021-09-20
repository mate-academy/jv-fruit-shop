package core.basesyntax.service.operation;

import core.basesyntax.model.FruitRecord;

public interface OperationStrategy {
    OperationHandler get(FruitRecord.Type typeOfOperation);
}
