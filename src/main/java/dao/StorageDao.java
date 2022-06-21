package dao;

public interface StorageDao {
    void addNewFruit(String fruit, int quantity);

    void changeQuantityOfFruit(String fruit, int quantity);
}
