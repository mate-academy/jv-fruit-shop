package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.model.Transaction;

public interface Operational {

    void operation(Transaction transaction, Storage fruitStorage);
}
