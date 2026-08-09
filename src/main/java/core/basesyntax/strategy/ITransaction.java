package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface ITransaction {
    void execute(FruitTransaction transaction, Storage storage);
}
