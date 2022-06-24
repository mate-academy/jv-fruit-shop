package core.basesyntax.service.handlers;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(Fruit fruit, Integer quantity) {
        Warehouse.getWarehouse().put(fruit, Warehouse.getWarehouse().get(fruit) + quantity);
    }
}
