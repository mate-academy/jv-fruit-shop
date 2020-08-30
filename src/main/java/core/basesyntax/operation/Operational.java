package core.basesyntax.operation;

import core.basesyntax.model.Transaction;

public interface Operational {

    void operation(Transaction transaction);
}
