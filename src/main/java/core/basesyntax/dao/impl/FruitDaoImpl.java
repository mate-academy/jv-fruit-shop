package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.repository.FruitDB;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void updateStock(String fruit, int amount) {
        int newAmount = amount;
        if (FruitDB.fruitsOnStock.get(fruit) != null) {
            newAmount = (FruitDB.fruitsOnStock.get(fruit)) + amount;
        }
        if (newAmount < 0) {
            throw new RuntimeException("Client wants to buy more products than are available");
        }
        FruitDB.fruitsOnStock.put(fruit, newAmount);
    }

    @Override
    public Map<String, Integer> getStock() {
        return FruitDB.fruitsOnStock;
    }
}
