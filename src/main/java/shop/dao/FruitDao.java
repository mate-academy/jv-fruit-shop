package shop.dao;

import java.util.List;
import shop.model.Fruit;

public interface FruitDao {

    List<Fruit> getAll();

    boolean add(Fruit fruit);

    Fruit get(String name);
}
