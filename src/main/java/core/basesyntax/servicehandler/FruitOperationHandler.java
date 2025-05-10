package core.basesyntax.servicehandler;

import core.basesyntax.model.FruitTransaction;

public interface FruitOperationHandler {
    void handle(FruitTransaction transaction);
}
