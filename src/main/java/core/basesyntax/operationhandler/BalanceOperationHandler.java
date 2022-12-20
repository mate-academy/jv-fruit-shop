package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransfer;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void app(FruitTransfer transfer) {
        Storage.storageMap.put(transfer.getFruit(),transfer.getRemainder());
    }
}
