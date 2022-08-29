package dao;

import java.util.Map;

public interface StorageDao {

    void update(String fruit, Integer quantity);

    int remainder(String fruit);

    Map<String, Integer> getStorage();
}
