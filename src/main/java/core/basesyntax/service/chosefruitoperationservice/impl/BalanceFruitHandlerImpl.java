package core.basesyntax.service.chosefruitoperationservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.chosefruitoperationservice.FruitOperationHandler;

public class BalanceFruitHandlerImpl implements FruitOperationHandler {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.BALANCE;
    }
}
