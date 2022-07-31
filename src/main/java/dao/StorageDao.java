package dao;

import java.util.List;
import model.Fruit;

public interface StorageDao {
    void update(String fruitName,Integer amount);

    Integer getFruitQuantity(String fruit);

    List<Fruit> getAll();
}
