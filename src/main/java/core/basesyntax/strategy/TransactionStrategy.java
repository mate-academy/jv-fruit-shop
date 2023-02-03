package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transaction.OperationHandler;

public interface TransactionStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
