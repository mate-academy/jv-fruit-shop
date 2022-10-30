package core.fruitshop.dao;

public interface StorageDao {
    void addProduct(String productName, int amount);

    void minusAmount(String productName, int amount);

    void addAmount(String productName, int amount);
}
