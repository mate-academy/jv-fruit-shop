package core.basesyntax.Service;

import core.basesyntax.Service.HandlerFruits.FruitsHandler;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    FruitsHandler getEnum(FruitTransaction.Operation type);
}
