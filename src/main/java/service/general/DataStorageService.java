package service.general;

import java.util.Map;

public interface DataStorageService {
    void putValue(String key, Integer value);

    Integer getValue(String key);

    Map<String, Integer> getFruitMap();
}
