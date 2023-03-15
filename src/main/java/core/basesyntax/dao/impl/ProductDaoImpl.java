package core.basesyntax.dao.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.storage.ProductStorage;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

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
    public Map<String, Integer> getAllProducts() {
        return ProductStorage.products;
    }
}
