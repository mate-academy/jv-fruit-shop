package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StorageDao {

    void addToStorage(Fruit fruit);

    Fruit getFromStorage(String fruitType);

    void updateStorage(Fruit fruit);

    List<Fruit> getAllFruits();

}
