package dao;

import java.util.List;
import shop.item.Fruit;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(Fruit fruit);

    void update(Fruit fruit);

    List<Fruit> getAll();
}
