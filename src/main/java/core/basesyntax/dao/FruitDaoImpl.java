package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<Fruit, Integer> getBalance() {
        return Storage.fruits;
    }

    @Override
    public Integer getAmount(Fruit fruit) {
        return Storage.fruits.entrySet().stream()
                .filter(e -> e.getKey().equals(fruit))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find element "
                        + fruit.getName() + " in storage"));
    }

    @Override
    public void update(Fruit fruit, Integer amount) {
        Storage.fruits.put(fruit, amount);
    }
}
