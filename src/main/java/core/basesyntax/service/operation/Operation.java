package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface Operation {
    void processWithTransaction(FruitTransaction transaction);
}
