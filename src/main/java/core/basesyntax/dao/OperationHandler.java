package core.basesyntax.dao;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
