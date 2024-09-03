package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {
    Map<String, Integer> getAllFruits();

    int getFruitQuantity(String fruit);
}
