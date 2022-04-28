package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineInformation;

public class SupplyOperation implements OperationHandler {

    @Override
    public boolean operation(LineInformation lineInformation) {
        Fruit fruit = new Fruit(lineInformation.getFruitName());
        int quantity = lineInformation.getQuantity();
        int storageQuantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit, storageQuantity + quantity);
        return true;
    }
}
