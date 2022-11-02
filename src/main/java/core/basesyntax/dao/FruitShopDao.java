package core.basesyntax.dao;

import java.util.Map;

public interface FruitShopDao {
    void add(String fruitName, int quantity);

    void supply(String fruitName, int quantity);

    void purchase(String fruitName, int quantity);

    Map<String,Integer> getAll();

}
