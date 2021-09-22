package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;

public class SetBalanceOperationImpl implements OperationHandler {
    @Override
    public void setBalance(FruitRecord record) {
        Storage.getStorage().put(record.getFruitName(), record.getBalance());
    }
}
