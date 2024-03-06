package dao;

import java.util.List;
import model.Fruit;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    void update(Fruit fruit);

    List<Fruit> getAll();
}
