package core.basesyntax.dao;

import java.util.Set;

public interface FruitDao {
    void updateQuantity(String fruit, Integer amount);

    Set<String> getFruits();

    Integer getFruitQuantity(String fruit);
}
