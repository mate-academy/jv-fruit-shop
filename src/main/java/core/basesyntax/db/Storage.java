package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    void updateFruitBalance(String fruit, int quantity);

    int getFruitBalance(String fruit);

    void setFruitBalance(String fruit, int newBalance);

    Map<String,Integer> getAll();
}
