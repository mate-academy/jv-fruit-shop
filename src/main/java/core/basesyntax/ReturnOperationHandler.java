package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void operate(String fruitName, int quantiti) {
        int oldQuantiti = Storage.storage.get(new Fruit(fruitName));
        int actual = oldQuantiti + quantiti;
        Storage.storage.put(new Fruit(fruitName), actual);
    }
}
