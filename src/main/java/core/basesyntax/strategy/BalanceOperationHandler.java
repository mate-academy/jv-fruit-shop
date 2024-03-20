package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction input) {
        Storage.dataBase.put(input.fruit(), input.quantity());
    }

    @Override
    public boolean isAplicable(FruitTransaction input) {
        return Operation.BALANCE == input.operation();
    }
}
