package core.basesyntax.service.interfaces;

import core.basesyntax.model.FruitTransaction;

public interface FindTransactionType {
    FruitTransaction.Operation operationType(String operation);
}
