package core.basesyntax.dao.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.storage.ProductStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    private static final String COMMA = ",";

    @Override
    public void updateAmount(String fruitName, int quantity) {
        ProductStorage.products.put(fruitName, quantity);
    }

    @Override
    public void addAmount(String fruitName, int quantity) {
        for (Map.Entry<String, Integer> entry : ProductStorage.products.entrySet()) {
            if (entry.getKey().equals(fruitName)) {
                entry.setValue(entry.getValue() + quantity);
                return;
            }
        }
        ProductStorage.products.put(fruitName, quantity);
    }

    @Override
    public void subtractAmount(String fruitName, int quantity) {
        for (Map.Entry<String, Integer> entry : ProductStorage.products.entrySet()) {
            if (entry.getKey().equals(fruitName)) {
                entry.setValue(entry.getValue() - quantity);
                return;
            }
        }
        throw new RuntimeException("Impossible to get product from empty productStorage!");
    }

    @Override
    public List<String> getAllProducts() {
        List<String> products = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ProductStorage.products.entrySet()) {
            String productInfo = entry.getKey() + COMMA + entry.getValue();
            products.add(productInfo);
        }
        return products;
    }
}
