package mate.academy.dao;

import java.util.List;
import mate.academy.model.Fruit;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    List<Fruit> getList();
}
