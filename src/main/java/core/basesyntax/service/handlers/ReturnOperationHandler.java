package core.basesyntax.service.handlers;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void processOperation(Operation operation, Fruit fruit, Integer quantity) {
        Warehouse.getWarehouse().put(fruit, Warehouse.getWarehouse().get(fruit) + quantity);
    }
}
