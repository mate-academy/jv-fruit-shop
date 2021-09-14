package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public int getChangedAmount(FruitRecord record) {
        Storage.getStorage().put(record.getFruit(), record.getAmount());
        return record.getAmount();
    }
}
