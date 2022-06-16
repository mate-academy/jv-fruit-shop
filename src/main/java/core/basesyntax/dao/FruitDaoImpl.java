package core.basesyntax.dao;

import core.basesyntax.db.FruitsStorage;

import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getData() {
        if (FruitsStorage.fruitsStorage.isEmpty()) {
            throw new RuntimeException("Fruit storage is empty!");
        }
        return FruitsStorage.fruitsStorage;
    }

    @Override
    public Integer getFruitQuantity(String fruit) {
        return FruitsStorage.fruitsStorage.entrySet().stream()
                .filter(a -> a.getKey().equalsIgnoreCase(fruit))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such fruit in storage! " + fruit));
    }

    @Override
    public void update(String fruit, Integer quantity) {
        if (fruit == null || quantity == null) {
            throw new RuntimeException("You can't put to storage NULL!");
        }
        FruitsStorage.fruitsStorage.put(fruit, quantity);
    }
}
