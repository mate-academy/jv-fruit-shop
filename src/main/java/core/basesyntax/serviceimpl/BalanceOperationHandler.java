package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationService;

public class BalanceOperationHandler implements OperationService {
    @Override
    public void handle(FruitTransaction fruit) {
        Storage.DB.put(fruit.getFruit(), fruit.getQuantity());
    }
}
