package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handlerfruits.FruitsHandler;

public interface OperationHandler {
    FruitsHandler getEnum(FruitTransaction.Operation type);
}
