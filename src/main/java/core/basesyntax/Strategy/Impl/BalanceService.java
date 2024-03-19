package core.basesyntax.Strategy.Impl;

import core.basesyntax.OperationHandler;
import core.basesyntax.model.FruitsTransaction;

public class BalanceService implements OperationHandler {
    @Override
    public void apply(FruitsTransaction transaction) {

    }

    @Override
    public boolean isApplicable(FruitsTransaction transaction) {
        return FruitsTransaction.Operation.BALANCE == transaction.getOperation() ;
    }
}
