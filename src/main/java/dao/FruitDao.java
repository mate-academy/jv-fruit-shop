package dao;

public interface FruitDao {
    void add(String key, int value);

    void remove(String key, int value);

    Integer get(String key);
}
