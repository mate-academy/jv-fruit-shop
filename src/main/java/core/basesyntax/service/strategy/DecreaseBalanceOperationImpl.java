package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;

public class DecreaseBalanceOperationImpl implements OperationHandler {
    @Override
    public void setBalance(FruitRecord record) {
        int count = Storage.getStorage().get(record.getFruitName()) - record.getBalance();
        Storage.getStorage().put(record.getFruitName(), count);
    }
}
