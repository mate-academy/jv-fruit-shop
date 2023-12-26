package core.basesyntax.service;

import core.basesyntax.constants.Products;
import core.basesyntax.products.Product;
import java.util.List;

public interface DatabaseDaoService {
    public void put(Products product, Integer amount);

    public void reduceAmount(Products products, Integer amount);

    public void increaseAmount(Products products, Integer amount);

    public List<Product> getAll();
}
