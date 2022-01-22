package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void operate(String fruitName, int quantity) {
        if (!Storage.storage.containsKey(new Fruit(fruitName))) {
            Storage.storage.put(new Fruit(fruitName), quantity);
        } else {
            int oldQuantity = Storage.storage.get(new Fruit(fruitName));
            int actual = oldQuantity + quantity;
            Storage.storage.put(new Fruit(fruitName), actual);
        }
    }
}
