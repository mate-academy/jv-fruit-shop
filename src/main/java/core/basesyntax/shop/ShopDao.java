package core.basesyntax.shop;

import java.util.Map;

public interface ShopDao {
    void add(String item, int quantity);

    void subtract(String item, int quantity) throws InsufficientGoodsException;

    Map<String, Integer> returnMap();
}
