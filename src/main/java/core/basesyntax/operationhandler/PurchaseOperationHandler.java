package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransfer;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void app(FruitTransfer transfer) {
        Fruit fruit = transfer.getFruit();
        Integer currentValue = Storage.storageMap.get(fruit);
        if (currentValue == null) {
            throw new RuntimeException("current value can't be null");
        } else if (currentValue < transfer.getRemainder()) {
            throw new RuntimeException("current value can't be more less then purchase value");
        } else {
            Storage.storageMap.put(fruit,currentValue - transfer.getRemainder());
        }
    }
}
