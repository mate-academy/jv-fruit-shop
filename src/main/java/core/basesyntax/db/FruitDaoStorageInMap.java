package core.basesyntax.db;

import core.basesyntax.errors.DaoError;
import java.util.HashMap;
import java.util.Map;

public class FruitDaoStorageInMap implements FruitDao {
    private final Map<String, Integer> db;

    public FruitDaoStorageInMap() {
        this.db = new HashMap<>();
    }

    @Override
    public void increment(String fruit, int count) {
        int currentCount = getCount(fruit);
        currentCount += count;
        setCount(fruit, currentCount);
    }

    @Override
    public void decrement(String fruit, int count) {
        int currentCount = getCount(fruit);
        if (count > currentCount) {
            throw new DaoError("Don't enough " + fruit
                    + ", need " + count
                    + ", available " + currentCount);
        }
        currentCount -= count;
        setCount(fruit, currentCount);
    }

    @Override
    public int getCount(String fruit) {
        Integer count = db.get(fruit);
        if (count == null) {
            return 0;
        }
        return count;
    }

    @Override
    public String[] getAllFruits() {
        return db.keySet().toArray(new String[0]);
    }

    private void setCount(String fruit, int count) {
        db.put(fruit, count);
    }
}
