package core.basesyntax.strategy;

import core.basesyntax.storage.Storage;
import core.basesyntax.transactions.FruitTransaction;

public interface OperationStrategy {
    void process(FruitTransaction transaction, Storage storage);
}

