package core.basesyntax.dao;

public interface StorageDao {
    Integer getQuantity(String product);

    void update(String product, Integer quantity);

    void delete(String product);
}
