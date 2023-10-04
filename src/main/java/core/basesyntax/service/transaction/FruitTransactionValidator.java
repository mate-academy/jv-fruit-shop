package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionValidator {
    boolean isValid(FruitTransaction fruitTransaction);
}
