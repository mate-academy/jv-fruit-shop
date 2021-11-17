package core.basesyntax.shop;

import java.util.Map;

public interface ShopService {

    void balance(String type, Integer quantity);

    void supply(String item, Integer quantity);

    void purchase(String item, Integer quantity);

    void returnBack(String item, Integer quantity);

    Map<String, Integer> getMap();
}
