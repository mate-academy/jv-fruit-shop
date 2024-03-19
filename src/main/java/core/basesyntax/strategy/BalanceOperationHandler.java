package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction input) {
        Storage.dataBase.put(input.fruit(), input.quantity());
    }

    @Override
    public boolean isAplicable(FruitTransaction input) {
        return "b".equals(input.operation().getCode());
    }
}
