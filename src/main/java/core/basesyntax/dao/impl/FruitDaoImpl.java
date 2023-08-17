package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import java.math.BigDecimal;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String name, BigDecimal quantity) {
        FruitStorage.fruits.put(name, quantity);
    }

    @Override
    public Map.Entry<String, BigDecimal> get(String fruitName) {
        return FruitStorage.fruits.entrySet().stream()
                .filter(e -> e.getKey().equals(fruitName))
                .findFirst().orElse(null);
    }

    @Override
    public void update(String fruitName, BigDecimal quantity) {
        FruitStorage.fruits.remove(fruitName);
        add(fruitName, quantity);
    }

    @Override
    public Map<String, BigDecimal> getAll() {
        return FruitStorage.fruits;
    }
}
