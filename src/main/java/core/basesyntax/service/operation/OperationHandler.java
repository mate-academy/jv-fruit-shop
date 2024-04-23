package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction transaction, FruitStorage storage);
}
