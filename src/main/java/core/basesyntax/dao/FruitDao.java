package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    int getData(String fruit);

    void putInData(String fruit, int quantity);

    void updateData(String fruit, int newQuantity);

    Map<String, Integer> getAll();
}
