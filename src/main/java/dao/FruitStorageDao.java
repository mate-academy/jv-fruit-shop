package dao;

import java.util.Map;
import model.Fruit;

public interface FruitStorageDao {
    Fruit getFruit(String name);

    void set(String name, Integer quantity);

    void add(String name, Integer quantity);

    void remove(String name, Integer quantity);

    Map<String, Integer> getFruits();
}
