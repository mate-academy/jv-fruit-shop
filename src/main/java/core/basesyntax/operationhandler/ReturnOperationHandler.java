package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransfer;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransfer transfer) {
        Fruit fruit = transfer.getFruit();
        Integer currentValue = Storage.storageMap.get(fruit);
        Storage.storageMap.put(fruit,currentValue + transfer.getAmount());
    }
}
