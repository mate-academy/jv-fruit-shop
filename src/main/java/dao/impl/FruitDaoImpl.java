package dao.impl;

import dao.FruitDao;
import db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public boolean containsFruit(String fruit) {
        return Storage.getFruitsStorage().containsKey(fruit);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.getFruitsStorage().get(fruit);
    }

    @Override
    public void update(String fruit, int quantity) {
        Storage.getFruitsStorage().put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.getFruitsStorage();
    }
}
