package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void process(FruitTransaction transaction, Storage storage);
}
