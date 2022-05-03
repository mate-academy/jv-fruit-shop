package dao;

public interface FruitsDao {
    void addProduct(String product, Integer count);

    Integer getValue(String product);
}
