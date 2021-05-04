package core.basesyntax.database;

import core.basesyntax.service.Product;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Product, Integer> products = new HashMap<>();

    public static Map<Product, Integer> getProducts() {
        return products;
    }
}
