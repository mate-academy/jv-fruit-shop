package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;

public interface OperationHandler {
    void dataHandler(FruitTransaction fruit);
}
