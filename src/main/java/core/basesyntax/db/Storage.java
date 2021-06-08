package core.basesyntax.db;

import core.basesyntax.service.Product;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Product, Integer> productsMap = new HashMap<>();

    public static Map<Product, Integer> getProducts() {
        return productsMap;
    }
}
