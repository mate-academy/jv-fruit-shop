package dao;

import java.util.Map;

public interface StorageDao {
    void updateData(String fruit, Integer quantity);

    Integer getRemainFruit(String fruit);

    Map<String, Integer> getStorage();
}
