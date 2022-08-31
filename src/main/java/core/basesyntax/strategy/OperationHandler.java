package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import java.util.prefs.BackingStoreException;

public interface OperationHandler {
    void apply(Transaction transaction) throws BackingStoreException;
}
