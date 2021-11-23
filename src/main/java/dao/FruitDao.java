package dao;

import java.util.List;
import model.Fruit;

public interface FruitDao {
    Fruit add(Fruit fruit);

    Fruit get(String name);

    List<Fruit> getAll();
}
