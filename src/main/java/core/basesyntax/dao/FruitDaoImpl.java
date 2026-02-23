package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new RuntimeException("Fruit name cannot be null or empty");
        }

        int currentBalance = getQuantity(fruit);
        int newBalance = currentBalance + quantity;

        if (newBalance < 0) {
            throw new RuntimeException("Balance can't be negative for: " + fruit);
        }

        Storage.update(fruit, newBalance);
    }

    @Override
    public Integer getQuantity(String fruit) {
        // Додамо перевірку входу, як просив рев'юер
        if (fruit == null || fruit.isBlank()) {
            throw new RuntimeException("Fruit name cannot be null or empty");
        }
        Integer quantity = Storage.get(fruit);
        return (quantity == null) ? 0 : quantity;
    }

    @Override
    public Map<String, Integer> getAllFruits() {

        return Storage.getAll();
    }
}
