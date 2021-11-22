package core.basesyntax.shop.service;

import java.util.Map;

public interface ParseShopData {
    String collect(Map<String, Integer> map);

    boolean distribute(String table);
}
