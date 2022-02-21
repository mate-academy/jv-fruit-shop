package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface Strategy {
    OperationHandler getActivity(Transaction.Operation operation);
}
