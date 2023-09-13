package dao;

import model.Fruit;

public interface FruitDao {
    Fruit add(Fruit fruit);

    boolean check(Fruit fruit);
    Fruit get(Fruit fruit);
    Fruit update(Fruit fruit);
    Fruit increaseQuantity(Fruit fruit);
    Fruit decreaseQuantity(Fruit fruit);
}
