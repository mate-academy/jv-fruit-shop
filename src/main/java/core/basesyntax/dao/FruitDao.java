package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public interface FruitDao {

    void put(String fruitName, int quantity);

    int get(String fruitName);

    Storage getStorage();
}
