package core.basesyntax.db;

public interface ShopDao {
    void addFruitFromBalance(String fruit, Integer quantity);

    void updateFruitQuantity(String fruit, Integer quantity);
}
