package core.fruitshop.dao;

import core.fruitshop.model.Fruit;
import java.util.Set;

public interface FruitDao {
    void addFruit(Fruit fruit);

    Integer getQuantity(Fruit fruit);

    Set<Fruit> getFruitsSet();
}
