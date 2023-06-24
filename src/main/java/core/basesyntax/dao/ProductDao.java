package core.basesyntax.dao;

import java.util.Map;

public interface ProductDao {
    void updateAmount(String fruitName, int quantity);

    void addAmount(String fruitName, int quantity);

    void subtractAmount(String fruitName, int quantity);

    Map<String, Integer> getAllProducts();
}
