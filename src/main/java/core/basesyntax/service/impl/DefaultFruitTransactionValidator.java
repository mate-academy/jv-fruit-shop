package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionValidator;

public class DefaultFruitTransactionValidator implements FruitTransactionValidator {
    @Override
    public boolean isValid(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity() > 0;
    }
}
