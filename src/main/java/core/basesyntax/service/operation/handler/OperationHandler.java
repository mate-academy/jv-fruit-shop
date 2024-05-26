package core.basesyntax.service.operation.handler;

import core.basesyntax.model.FruitModel;

public interface OperationHandler {
    void operationType(FruitModel fruitModel, int amount);
}
