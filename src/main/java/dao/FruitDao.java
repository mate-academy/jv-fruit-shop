package dao;

import java.util.List;
import model.Fruit;

public interface FruitDao {
    List<Fruit> getListRemainder();

    boolean add(Fruit fruit);

    Fruit getByName(String name);
}
