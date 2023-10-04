package core.basesyntax.service.interfaces;

import core.basesyntax.model.FruitTransaction;

public interface TransactionTypeFinder {
    FruitTransaction.Operation operationType(String operation);
}
