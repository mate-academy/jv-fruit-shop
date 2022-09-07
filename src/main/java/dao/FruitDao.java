package dao;

import java.util.Map;
import model.Fruit;

public interface FruitDao {
    void update(Fruit fruit, Integer quantity);

    Integer getQuantity(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
