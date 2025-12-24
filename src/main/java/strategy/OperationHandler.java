package strategy;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
