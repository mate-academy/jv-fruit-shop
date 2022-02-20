package services;

import model.Fruit;
import model.FruitRecord;

import java.util.Set;

public interface FruitDaoService {
    void put(FruitRecord fruitRecord);

    void save(FruitRecord fruitRecord);

    Set<Fruit> get();

    Set<Fruit> getAll();
}
