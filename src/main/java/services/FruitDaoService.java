package services;

import java.util.Set;
import model.Fruit;
import model.FruitRecord;

public interface FruitDaoService {
    void put(FruitRecord fruitRecord);

    void save(FruitRecord fruitRecord);

    Set<Fruit> get();
}
