package core.basesyntax.strategy.operation;

import core.basesyntax.model.Transaction;

public interface Operation {
    void apply(Transaction transaction);
}
