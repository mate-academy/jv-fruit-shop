package dao;

import java.util.List;
import model.FruitTransaction;

public interface StorageDao {
    void update(String fruitName, Integer amount);

    Integer getFruitQuantity(String fruit);

    List<FruitTransaction> getAll();
}
