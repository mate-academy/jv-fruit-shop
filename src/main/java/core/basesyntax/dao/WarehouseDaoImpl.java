package core.basesyntax.dao;

import core.basesyntax.db.Warehouse;
import java.util.Map;

public class WarehouseDaoImpl implements WarehouseDao {
    @Override
    public void addLeftovers(String fruit, Integer quantity) {
        Warehouse.warehouse.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getWarehouse() {
        return Warehouse.warehouse;
    }
}
