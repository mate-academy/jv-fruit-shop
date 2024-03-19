package core.basesyntax.repository;

import core.basesyntax.model.Transaction;
import java.util.HashMap;
import java.util.Map;

public class StorageRepository {
    private static final Map<String, Integer> products = new HashMap<>();

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void addProduct(Transaction transaction) {
        products.put(transaction.getProduct(), transaction.getValue());
    }
}
