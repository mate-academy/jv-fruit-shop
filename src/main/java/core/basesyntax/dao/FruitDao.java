package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addData(Map<String, Integer> statistics);

    Map<String, Integer> getData();
}
