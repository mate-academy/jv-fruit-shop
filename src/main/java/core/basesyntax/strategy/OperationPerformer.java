package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationPerformer {
    void perform(FruitTransaction transaction, Storage storage);
}
