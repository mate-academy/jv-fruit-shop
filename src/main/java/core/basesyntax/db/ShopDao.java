package core.basesyntax.db;

public interface ShopDao {
    void addFruit(String fruit, Integer quantity);

    void changeFruitQuantity(String fruit, Integer quantity);
}
