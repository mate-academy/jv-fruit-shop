package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;

public class IncreaseAmountOperationHandlerImpl implements OperationHandler {
    @Override
    public int getChangedAmount(FruitRecord record) {
        int newAmount = Storage.getStorage().get(record.getFruit()) + record.getAmount();
        Storage.getStorage().put(record.getFruit(), newAmount);
        return newAmount;
    }
}
