package core.basesyntax.strategy.handlers;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
