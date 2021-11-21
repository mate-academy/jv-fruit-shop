package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    void changeFruitCountInStorage(int newCount, String fruitName);

    int getCurrentCountFruitsInStorage(String fruitName);

    String getAllDataFromDB();
}
