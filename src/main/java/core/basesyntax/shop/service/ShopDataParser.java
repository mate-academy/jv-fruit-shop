package core.basesyntax.shop.service;

import java.util.Map;

public interface ShopDataParser {
    String collect(Map<String, Integer> map);

    boolean distribute(String table);
}
