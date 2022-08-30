package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface Counter {
    void apply(Transaction transaction);
}
