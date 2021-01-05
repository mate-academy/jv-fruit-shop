package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void apply(Storage storage, Fruit fruit, int amount);
}
