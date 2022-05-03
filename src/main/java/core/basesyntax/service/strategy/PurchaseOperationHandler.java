package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineData;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public boolean operate(LineData lineData) {
        Fruit fruit = lineData.getFruit();
        int quantity = lineData.getQuantity();
        int storageQuantity = Storage.store.get(fruit);
        if (quantity > storageQuantity) {
            throw new RuntimeException("There no enough " + lineData.getFruit());
        }
        Storage.store.put(fruit, storageQuantity - quantity);
        return true;
    }
}
