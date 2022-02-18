package core.basesyntax.dao;

import java.util.Set;

public interface FruitDao {
    void addQuantity(String fruit, Integer amount);

    void subtractQuantity(String fruit, Integer amount);

    Set<String> getFruits();

    Integer getFruitQuantity(String fruit);
}
