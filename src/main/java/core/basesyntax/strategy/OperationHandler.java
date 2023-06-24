package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
