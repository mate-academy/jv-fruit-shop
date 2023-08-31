package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;

public class SupplyReturnOperationService implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        Storage.storage.put(fruit.getFruit(), Storage.storage.get(fruit.getFruit())
                + fruit.getQuantity());
    }
}
