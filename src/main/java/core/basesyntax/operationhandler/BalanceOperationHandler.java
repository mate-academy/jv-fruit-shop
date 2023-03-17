package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransfer;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransfer transfer) {
        Storage.storageMap.put(transfer.getFruit(), transfer.getAmount());
    }
}
