package core.basesyntax.db;

import java.util.Map;

public interface DatabaseDaoService {
    void put(String product, Integer amount);

    void reduceAmount(String product, Integer amount);

    void increaseAmount(String product, Integer amount);

    Map<String, Integer> getAll();

    Integer getProductAmount(String product);
}
