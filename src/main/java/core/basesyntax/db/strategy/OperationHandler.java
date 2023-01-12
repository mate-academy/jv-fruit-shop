package core.basesyntax.db.strategy;

import core.basesyntax.db.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
