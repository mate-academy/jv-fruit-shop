package core.basesyntax.dao;

public interface FruitStockDao {
    int get(String fruit);

    void put(String fruit, Integer quantity);
}
