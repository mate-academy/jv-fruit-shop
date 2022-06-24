package core.basesyntax.service.handlers;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(Fruit fruit, Integer quantity) {
        Warehouse.getWarehouse().put(fruit, quantity);
    }
}
