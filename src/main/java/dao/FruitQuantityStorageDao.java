package dao;

public interface FruitQuantityStorageDao {
    void add(String fruitName, int fruitQuantity);

    int get(String fruitName);
}
