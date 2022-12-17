package dao;

import java.util.Map;
import model.Fruit;

public interface FruitStorageDao {
    boolean add(Fruit fruit, Integer amount);

    boolean update(Fruit fruit, Integer amount);

    Integer getAmountByFruit(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
