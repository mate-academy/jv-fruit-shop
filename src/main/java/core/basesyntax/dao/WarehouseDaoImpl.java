package core.basesyntax.dao;

import static core.basesyntax.db.Warehouse.warehouse;

import core.basesyntax.db.Warehouse;
import java.util.Map;

public class WarehouseDaoImpl implements WarehouseDao {
    @Override
    public void updateQuantity(String fruit, Integer quantity) {
        warehouse.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return warehouse.get(fruit);
    }

    @Override
    public String getFruitFromDb(String fruit) {
        for (Map.Entry<String, Integer> entry : warehouse.entrySet()) {
            if (entry.getKey().equals(fruit)) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("Can't find fruit \"" + fruit + "\" in data base");
    }

    @Override
    public Map<String, Integer> getLeftovers() {
        return Warehouse.warehouse;
    }
}
