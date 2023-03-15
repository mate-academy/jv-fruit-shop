package core.basesyntax.dao;

public interface FruitShopDao {
    void add(String fruit, Integer value);
    int get(String fruit);
}
