package core.basesyntax.service.handlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction transaction);
}
