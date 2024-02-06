package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.transactionsService.OperationHandler;

public interface OperationGetter {
    OperationHandler getOperation(Transaction transaction);

}
