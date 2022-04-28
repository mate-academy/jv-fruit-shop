package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineInformation;

public class PurchaseOperation implements OperationHandler {

    @Override
    public boolean operation(LineInformation lineInformation) {
        Fruit fruit = new Fruit(lineInformation.getFruitName());
        int quantity = lineInformation.getQuantity();
        int storageQuantity = Storage.storage.get(fruit);
        if (quantity > storageQuantity) {
            return false;
        }
        Storage.storage.put(fruit, storageQuantity - quantity);
        return true;
    }
}
