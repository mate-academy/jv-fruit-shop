package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface Operation {
    void execute(Transaction transaction);
}
