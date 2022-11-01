package core.basesyntax.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void process(FruitTransaction transaction);
}
