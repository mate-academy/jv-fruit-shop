package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.impl.OperationHandler;

public interface TypeStrategy {
    OperationHandler getHandler(FruitRecord.Operation operation);
}
