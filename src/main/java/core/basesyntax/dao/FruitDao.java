package core.basesyntax.dao;

public interface FruitDao {
    void addProduct(String product, int quantity);

    void addProductQuantity(String product, int quantity);

    void subtract(String product, int quantity);

    int getAmount(String product);

    String[] getFruitsNames();
}
