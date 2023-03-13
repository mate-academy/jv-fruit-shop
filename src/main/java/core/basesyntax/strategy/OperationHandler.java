package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransfer;

public interface OperationHandler {
    void process(FruitTransfer fruitTransfer);
}
