package fruitshop.dao;

public interface FruitDao {
    void addToStorage(String key, Integer value);

    void addValue(String key, Integer value);

    void subtractValue(String key, Integer value);
}
