package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.transactionsservice.OperationHandler;

public interface OperationGetter {
    OperationHandler getOperation(Transaction transaction);

}
