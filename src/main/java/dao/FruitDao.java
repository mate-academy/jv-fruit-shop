package dao;

import model.Fruit;
import java.util.List;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    void update(Fruit fruit);

    List<Fruit> getAll();
}
