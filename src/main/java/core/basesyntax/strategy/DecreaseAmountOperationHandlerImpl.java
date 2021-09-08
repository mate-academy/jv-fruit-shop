package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;

public class DecreaseAmountOperationHandlerImpl implements OperationHandler {
    @Override
    public int getChangedAmount(FruitRecord record) {
        int amount = Storage.getStorage().get(record.getFruitName());
        int newAmount = amount - record.getAmount();
        Storage.getStorage().put(record.getFruitName(), newAmount);
        return newAmount;
    }
}
