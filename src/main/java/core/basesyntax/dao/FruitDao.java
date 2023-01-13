package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    Integer getQuantity(String fruit);

    void updateQuantity(String fruit, int quantity);

    boolean containsFruit(String fruit);

    Map<String, Integer> getStorage();
}
