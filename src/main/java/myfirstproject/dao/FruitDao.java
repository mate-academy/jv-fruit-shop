package myfirstproject.dao;

import java.util.Map;
import myfirstproject.model.Fruit;

public interface FruitDao {
    void saveFruit(Fruit fruit, int value);

    Map<Fruit, Integer> getAll();

    Integer getQuantity(Fruit fruit);
}
