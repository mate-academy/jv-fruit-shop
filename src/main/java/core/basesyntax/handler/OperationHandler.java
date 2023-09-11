package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction transaction);
}
