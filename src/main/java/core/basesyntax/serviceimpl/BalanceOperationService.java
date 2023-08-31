package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationService implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        Storage.storage.put(fruit.getFruit(), fruit.getQuantity());
    }
}
