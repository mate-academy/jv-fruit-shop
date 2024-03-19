package core.basesyntax.Strategy.Impl;

import core.basesyntax.OperationHandler;
import core.basesyntax.model.FruitsTransaction;

public class Purchase implements OperationHandler {
    @Override
    public void apply(FruitsTransaction transaction) {

    }

    @Override
    public boolean isApplicable(FruitsTransaction transaction) {
        return false;
    }
}
