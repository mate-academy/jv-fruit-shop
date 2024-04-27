package core.basesyntax.storage;

import java.util.Map;

public class Storage {
    private Map<String, Integer> productsMap;

    public Map<String, Integer> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(Map<String, Integer> productsMap) {
        this.productsMap = productsMap;
    }
}
