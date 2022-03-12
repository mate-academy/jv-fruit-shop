package dao;

import model.Fruit;

import java.util.List;

public interface FruitShopDao {
    void save(Fruit fruit);

    Integer getValue(Fruit fruit);

    List<Fruit> getAll();
}

