package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineData;

public class SupplyOperation implements OperationHandler {

    public boolean operate(LineData lineData) {
        Fruit fruit = lineData.getFruit();
        int quantity = lineData.getQuantity();
        int storageQuantity = Storage.store.get(fruit);
        Storage.store.put(fruit, storageQuantity + quantity);
        return true;
    }
}
