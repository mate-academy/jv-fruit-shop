package core.basesyntax.strategy;

import core.basesyntax.dao.Warehouse;
import core.basesyntax.dao.WarehouseImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Validation;

public class Purchase implements OperationStrategy {

    @Override
    public void apply(Fruit fruit, int amount) {
        Warehouse warehouse = new WarehouseImpl();
        Validation.isValid(warehouse, fruit, amount);
        warehouse.getItemFrom(fruit, amount);
    }
}
