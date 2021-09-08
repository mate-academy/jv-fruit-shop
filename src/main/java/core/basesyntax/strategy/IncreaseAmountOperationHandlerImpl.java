package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;

public class IncreaseAmountOperationHandlerImpl implements OperationHandler {
    @Override
    public int getChangedAmount(FruitRecord record) {
        int amount = Storage.storage.get(record.getFruitName());
        int newAmount = amount + record.getAmount();
        Storage.storage.put(record.getFruitName(), newAmount);
        return newAmount;
    }
}
