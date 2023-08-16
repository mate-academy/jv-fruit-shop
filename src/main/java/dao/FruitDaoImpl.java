package dao;

import db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitMap;
    }

    @Override
    public int getFruitQuantity(String fruitName) {
        return Storage.fruitMap.get(fruitName);
    }

    @Override
    public void setFruitQuantity(String fruitName, int quantity) {
        Storage.fruitMap.put(fruitName, quantity);
    }
}
