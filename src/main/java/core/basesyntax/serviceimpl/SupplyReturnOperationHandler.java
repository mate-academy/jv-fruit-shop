package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationService;

public class SupplyReturnOperationHandler implements OperationService {
    @Override
    public void handle(FruitTransaction fruit) {
        Storage.DB.put(fruit.getFruit(), Storage.DB.get(fruit.getFruit())
                + fruit.getQuantity());
    }
}
