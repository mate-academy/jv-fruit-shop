package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransfer;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void app(FruitTransfer transfer) {
        Fruit fruit = transfer.getFruit();
        Integer currentValue = Storage.storageMap.get(fruit);
        Storage.storageMap.put(fruit,currentValue + transfer.getRemainder());
    }
}
