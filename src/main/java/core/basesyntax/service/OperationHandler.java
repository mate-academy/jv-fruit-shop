package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;

public interface OperationHandler {
    int handle(FruitTransaction transaction);
}
