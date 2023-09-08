package dao;

import java.util.List;
import java.util.Optional;
import model.Fruit;

public interface FruitDao {
    List<Fruit> getAll();

    boolean add(Fruit fruit);

    Optional<Fruit> get(String name);
}
