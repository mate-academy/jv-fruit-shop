package core.basesyntax.db;

import java.util.Map;

public interface FruitDao {

    void add(String fruit, int quantity);

    void subtract(String fruit, int quantity);

    Map<String,Integer> getStorageQuantity();
}
