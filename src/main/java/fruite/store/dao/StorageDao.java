package fruite.store.dao;

public interface StorageDao {
    void addFruitToStorage(String key, Integer value);

    void addValueByKey(String key, Integer value);

    void subtractValueByKey(String key, Integer value);
}
