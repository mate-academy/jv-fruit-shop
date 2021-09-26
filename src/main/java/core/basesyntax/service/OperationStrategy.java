package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitRecord.Operation operation);
}
