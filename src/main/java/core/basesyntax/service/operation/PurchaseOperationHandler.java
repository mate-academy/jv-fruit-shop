package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer fruitsInStorage = Storage.reportMap.get(transaction.getFruit());
        Storage.reportMap.put(transaction.getFruit(),
                fruitsInStorage - transaction.getQuantity());
    }
}
