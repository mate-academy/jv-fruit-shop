package core.basesyntax.DAO;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface FruitStorageDao {
    void addFruitToStorage(Fruit fruit, Integer amount);
    Integer getFruitQuantityInStorage(Fruit fruit);
    Map<Fruit, Integer> getAllFromStorage();
}
