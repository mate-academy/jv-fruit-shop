package dao;

import java.util.List;
import model.Fruit;

public interface FruitShopDao {
    void save(Fruit fruit);

    Integer getValue(Fruit fruit);

    List<Fruit> getAll();
}

