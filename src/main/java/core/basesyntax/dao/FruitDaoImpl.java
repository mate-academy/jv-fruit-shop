package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitItem;
import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(FruitItem fruitItem) {
        Storage.fruits.put(fruitItem.getName(), fruitItem);
    }

    @Override
    public boolean containsName(String fruitName) {
        return Storage.fruits.containsKey(fruitName);
    }

    @Override
    public FruitItem getByName(String fruitName) {
        return Storage.fruits.get(fruitName);
    }

    @Override
    public List<FruitItem> getAll() {
        return new ArrayList<>(Storage.fruits.values());
    }

    @Override
    public void removeByName(String fruitName) {
        Storage.fruits.remove(fruitName);
    }
}
