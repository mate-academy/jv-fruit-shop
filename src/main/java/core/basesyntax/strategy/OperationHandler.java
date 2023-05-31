package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void toStorage(FruitTransaction transaction);
}
