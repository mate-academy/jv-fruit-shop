package core.basesyntax.shop.service;

import java.util.Map;

public interface FruitShopService {

    void balance(String type, Integer quantity);

    void supply(String item, Integer quantity);

    void purchase(String item, Integer quantity);

    void returnBack(String item, Integer quantity);

    Map<String, Integer> getMap();
}
