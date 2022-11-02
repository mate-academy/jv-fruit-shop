package core.basesyntax.dao;

public interface StorageDao {
    Integer readQuantity(String product);

    void updateProduct(String product, Integer quantity);

    void deleteProduct(String product);
}
