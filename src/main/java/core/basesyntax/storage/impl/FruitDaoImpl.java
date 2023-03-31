package core.basesyntax.storage.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.FruitDao;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    private static final Map<Fruit, Integer> dataBase = new HashMap<>();

    @Override
    public Set<Map.Entry<Fruit, Integer>> getEntries() {
        return dataBase.entrySet();
    }

    @Override
    public int getAmount(Fruit fruit) {
        return dataBase.get(fruit);
    }

    @Override
    public void updateBalance(Fruit fruit, int amount) {
        dataBase.put(fruit, amount);
    }

    @Override
    public void addToAmount(Fruit fruit, int value) {
        dataBase.put(fruit, dataBase.get(fruit) + value);
    }
}
