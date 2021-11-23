package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(String fruitName, int quantiti) {
        Storage.storage.put(new Fruit(fruitName), quantiti);
    }
}
