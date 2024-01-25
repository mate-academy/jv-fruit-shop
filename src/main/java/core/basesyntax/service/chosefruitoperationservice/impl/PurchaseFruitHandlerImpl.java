package core.basesyntax.service.chosefruitoperationservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.chosefruitoperationservice.FruitOperationHandler;

public class PurchaseFruitHandlerImpl implements FruitOperationHandler {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.PURCHASE;
    }
}
