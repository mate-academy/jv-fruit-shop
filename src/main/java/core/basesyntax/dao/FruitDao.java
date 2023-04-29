package core.basesyntax.dao;

import java.util.List;
import java.util.Map;

public interface FruitDao {
    List<String> get();

    void saveData(Map<String, Integer> processedData);
}

