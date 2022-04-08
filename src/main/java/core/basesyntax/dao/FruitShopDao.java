package core.basesyntax.dao;

public interface FruitShopDao {
    void addToStorage(String key, Integer value);

    void addValue(String key, Integer value);

    void subtractValue(String key, Integer value);
}
