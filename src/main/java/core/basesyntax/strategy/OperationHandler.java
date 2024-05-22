package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
