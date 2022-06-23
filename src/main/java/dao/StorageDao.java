package dao;

import java.util.Map;

public interface StorageDao {
    void update(String name, Integer newAmount);

    Map<String, Integer> getAll();
}
