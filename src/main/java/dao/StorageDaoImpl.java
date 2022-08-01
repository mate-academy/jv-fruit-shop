package dao;

import db.Storage;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void update(String fruitName, Integer amount) {
        Storage.storage.put(fruitName, amount);
    }

    @Override
    public Integer getFruitQuantity(String fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.storage.entrySet().stream()
                .map(s -> new FruitTransaction(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }
}
