package dao;

import java.util.List;

public interface FruitDao {

    Fruit add(Fruit fruit);

    List<Fruit> getAll();

    Fruit get(String name);
}






