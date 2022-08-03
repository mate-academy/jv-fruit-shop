package dao;

public interface StorageDao {
    void put(String name, Integer  amount);
    Integer get(String name);
    String getFruitReport();
}
