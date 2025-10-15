package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private final FruitDB fruitDB = new FruitDB();

    @Override
    public void set(String fruit, Integer quantity) {
        fruitDB.setQuantity(fruit, quantity);
    }

    @Override
    public void add(String fruit, Integer quantity) {
        fruitDB.setQuantity(fruit, fruitDB.getQuantity(fruit) + quantity);
    }

    @Override
    public void remove(String fruit, Integer quantity) {
        fruitDB.setQuantity(fruit, fruitDB.getQuantity(fruit) - quantity);
    }

    @Override
    public Map<String, Integer> getFruits() {
        return fruitDB.getFruits();
    }
}
