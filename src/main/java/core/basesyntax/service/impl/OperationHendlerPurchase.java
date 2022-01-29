package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHendler;

public class OperationHendlerPurchase implements OperationHendler {
    @Override
    public int getOperation(FruitTransaction fruitTransaction) {
        return -fruitTransaction.getQuantity();
    }
}
