package core.basesyntax.service.transaction.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.FruitTransactionValidator;

public class DefaultFruitTransactionValidator implements FruitTransactionValidator {
    @Override
    public boolean isValid(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity() > 0;
    }
}
