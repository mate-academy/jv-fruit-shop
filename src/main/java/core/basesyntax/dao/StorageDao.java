package core.basesyntax.dao;

public interface StorageDao {
    void saveFruit(String name, Integer quantity);

    Integer getQuantityByName(String name);

    void updateQuantityByName(String name, Integer quantity);
}
