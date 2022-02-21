package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void putDataIntoStorage(List<String> data);

    Set<Map.Entry<Fruit, Integer>> getDataFromStorage();
}
