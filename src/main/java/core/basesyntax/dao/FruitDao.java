package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addFruit(String fruit, Integer quantity);

    Integer getQuantity(String fruit);

    void mergeQuantity(String fruit, int quantity);

    boolean containsFruit(String fruit);

    Map<String, Integer> getStorage();
}
