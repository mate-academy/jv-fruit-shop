package core.basesyntax.dao;

import core.basesyntax.model.Product;

public interface fruitDao {
    void add(Product product);

    Product get(String productName);
}
