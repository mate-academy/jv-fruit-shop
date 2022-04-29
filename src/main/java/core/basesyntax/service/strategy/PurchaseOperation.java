package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineData;
import core.basesyntax.service.Parser;

public class PurchaseOperation implements Parser.OperationHandler {

    @Override
    public boolean operation(LineData lineData) {
        Fruit fruit = new Fruit(lineData.getFruitName());
        int quantity = lineData.getQuantity();
        int storageQuantity = Storage.store.get(fruit);
        if (quantity > storageQuantity) {
            throw new RuntimeException("There no enough " + lineData.getFruitName());
        }
        Storage.store.put(fruit, storageQuantity - quantity);
        return true;
    }
}
