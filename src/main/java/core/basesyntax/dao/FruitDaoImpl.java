package core.basesyntax.dao;

import core.basesyntax.db.FruitsStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getData() {
        return FruitsStorage.fruitsStorage;
    }

    @Override
    public Integer getFruitQuantity(String fruit) {
        return FruitsStorage.fruitsStorage.entrySet().stream()
                .filter(a -> a.getKey().equals(fruit))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such fruit in storage! " + fruit));
    }

    @Override
    public void update(String fruit, Integer quantity) {
        FruitsStorage.fruitsStorage.put(fruit, quantity);
    }
}
