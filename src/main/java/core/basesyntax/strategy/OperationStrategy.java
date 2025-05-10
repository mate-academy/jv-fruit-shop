package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void processTransaction(FruitTransaction transaction, Storage storage);
}
