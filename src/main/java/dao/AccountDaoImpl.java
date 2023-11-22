package dao;

import db.Storage;
import java.util.Map;

public class AccountDaoImpl implements AccountDao {
    @Override
    public int getAmountByFruit(String fruitName) {
        return Storage.STORAGE.get(fruitName);
    }

    @Override
    public void put(String fruitName, Integer quantity) {
        Storage.STORAGE.put(fruitName, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.STORAGE;
    }
}
