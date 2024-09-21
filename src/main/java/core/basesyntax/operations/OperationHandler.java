package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(Storage storage, FruitTransaction transaction);
}
