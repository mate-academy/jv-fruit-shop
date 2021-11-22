package core.basesyntax.shop.dao;

import java.util.Map;

public interface FruitShopDao {
    void add(String item, int quantity);

    void subtract(String item, int quantity) throws InsufficientGoodsException;

    Map<String, Integer> returnMap();
}
