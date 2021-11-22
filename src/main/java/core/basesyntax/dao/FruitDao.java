package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Optional;

public interface FruitDao {
    Fruit add(Fruit fruit);

    Optional<Fruit> get(String fruitName);

    void changeFruitCountInStorage(int newCount, String fruitName);

    int getCurrentCountFruitsInStorage(String fruitName);

    String getAllDataFromDB();
}
