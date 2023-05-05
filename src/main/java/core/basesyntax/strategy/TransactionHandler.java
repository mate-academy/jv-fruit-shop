package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.TransactionRecord;

public interface TransactionHandler {
    TransactionRecord get(FruitTransaction.Operation operation);
}
