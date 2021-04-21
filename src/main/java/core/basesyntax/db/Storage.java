package core.basesyntax.db;

import core.basesyntax.service.Product;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static Map<Product, Integer> productsMap = new TreeMap<>();

    public static void setProducts(Map<Product, Integer> productsMap) {
        Storage.productsMap = productsMap;
    }

    public static Map<Product, Integer> getProducts() {
        return productsMap;
    }
}
