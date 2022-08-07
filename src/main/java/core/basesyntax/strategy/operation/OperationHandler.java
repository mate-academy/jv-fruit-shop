package core.basesyntax.strategy.operation;

import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
