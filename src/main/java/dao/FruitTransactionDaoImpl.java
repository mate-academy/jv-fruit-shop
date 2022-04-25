package dao;

import database.Storage;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void addToStorage(String fruitName,Integer fruitQuantity) {
        Storage.fruitTransactionStorage.put(fruitName,fruitQuantity);
    }

    @Override
    public Integer getFromStorage(String fruitName) {
        return Storage.fruitTransactionStorage.getOrDefault(fruitName, 0);
    }
}
