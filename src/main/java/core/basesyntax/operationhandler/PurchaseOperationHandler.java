package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransfer;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransfer transfer) {
        Fruit fruit = transfer.getFruit();
        Integer currentValue = Storage.storageMap.get(fruit);
        if (currentValue == null) {
            throw new RuntimeException("current value can't be null");
        } else if (currentValue < transfer.getAmount()) {
            throw new RuntimeException("current value can't be more less then purchase value");
        }
        Storage.storageMap.put(fruit,currentValue - transfer.getAmount());
    }
}
