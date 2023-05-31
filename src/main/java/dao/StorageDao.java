package dao;

public interface StorageDao {
    void set(String fruit, int quantity);

    int get(String fruitName);
}
