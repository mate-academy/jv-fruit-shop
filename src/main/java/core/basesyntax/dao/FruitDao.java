package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    Map<String, Integer> getStorage();

    int getQualityByObjectType(String object);

    void putToStorage(String object, int quality);
}
