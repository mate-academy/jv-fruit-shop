package dao;

import java.util.Map;
import model.Fruit;

public interface FruitsDao {
    void addProduct(Fruit fruit, Integer count);

    Integer getValue(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
