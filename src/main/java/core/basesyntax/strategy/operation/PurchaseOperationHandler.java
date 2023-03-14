package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void accept(String fruit, String quantity) {
        Storage.STORAGE.put(fruit, Storage.STORAGE.get(fruit) - Integer.parseInt(quantity));
    }
}
