package core.basesyntax.strategy;

import core.basesyntax.dao.Warehouse;
import core.basesyntax.dao.WarehouseImpl;
import core.basesyntax.model.Fruit;

public class Supply implements OperationStrategy {
    @Override
    public void apply(Fruit fruit, int amount) {
        Warehouse warehouse = new WarehouseImpl();
        warehouse.addItem(fruit, amount);
    }
}
