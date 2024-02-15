package core.basesyntax.dao;

import java.util.Optional;

public interface FruitDao {
    Optional<Integer> getFruitQuantityByName(String name);

    void addFruitQuantity(String name, Integer quantity);

    void subtractFruitQuantity(String name, Integer quantity);
}
