package core.basesyntax.operation;

import core.basesyntax.Transaction;

public interface Operation {
    void provideOperation(Transaction transaction);
}
