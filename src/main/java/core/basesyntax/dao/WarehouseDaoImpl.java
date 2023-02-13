package core.basesyntax.dao;

import static core.basesyntax.db.Warehouse.warehouse;

import core.basesyntax.db.Warehouse;
import java.util.Map;

public class WarehouseDaoImpl implements WarehouseDao {
    @Override
    public void setQuantity(String fruit, Integer quantity) {
        warehouse.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return warehouse.get(fruit);
    }

    @Override
    public boolean isPresent(String fruit) {
        return warehouse.containsKey(fruit);
    }

    @Override
    public Map<String, Integer> getLeftovers() {
        return Warehouse.warehouse;
    }
}
