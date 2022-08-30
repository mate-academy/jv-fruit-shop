package core.basesyntax.storage.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.FruitDao;
import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final Map<Fruit, Integer> dataBase = new HashMap<>();

    @Override
    public Map<Fruit, Integer> getBalance() {
        return Map.copyOf(dataBase);
    }

    @Override
    public int getAmount(Fruit fruit) {
        return dataBase.get(fruit);
    }

    @Override
    public void updateBalance(Fruit fruit, int amount) {
        dataBase.put(fruit, amount);
    }
}
