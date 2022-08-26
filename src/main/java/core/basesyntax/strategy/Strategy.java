package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.OperationHandler;

public interface Strategy {
    OperationHandler get(FruitOperation.Operation operation);
}
