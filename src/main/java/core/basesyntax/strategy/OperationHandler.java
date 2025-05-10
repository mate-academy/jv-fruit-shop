package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransfer;

public interface OperationHandler {
    void performOperation(FruitTransfer fruitTransfer);
}
