package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface StorageDao {
    void addFruit(Fruit fruit);

    Fruit getFruit(String fruitName);

    void update(String fruit, int newQuantity);
}
