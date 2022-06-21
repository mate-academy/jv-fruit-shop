package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class ActionsDaoImpl implements ActionsDao {
    @Override
    public void add(String fruit, Integer amount) {
        Storage.data.put(fruit, amount);
    }

    @Override
    public void update(String fruit, Integer amount) {
        Storage.data.put(fruit, amount);
    }

    @Override
    public int getAmount(String fruit) {
        return Storage.data.get(fruit);
    }

    @Override
    public boolean isPresentFruit(String fruit) {
        return Storage.data.containsKey(fruit);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAllFruits() {
        return Storage.data.entrySet();
    }
}
