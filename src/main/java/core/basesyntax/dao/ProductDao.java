package core.basesyntax.dao;

import java.util.List;

public interface ProductDao {
    void updateAmount(String fruitName, int quantity);

    void addAmount(String fruitName, int quantity);

    void subtractAmount(String fruitName, int quantity);

    List<String> getAllProducts();
}
