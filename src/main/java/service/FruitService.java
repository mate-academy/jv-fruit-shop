package service;

import java.util.List;
import model.Fruit;

public interface FruitService {
    void add(String fruitName, Integer amount);

    Integer getQuantity(String fruitName);

    List<Fruit> getAll();
}
