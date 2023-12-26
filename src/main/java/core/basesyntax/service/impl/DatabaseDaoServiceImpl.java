package core.basesyntax.service.impl;

import core.basesyntax.constants.Products;
import core.basesyntax.db.DataBase;
import core.basesyntax.products.Product;
import core.basesyntax.service.DatabaseDaoService;
import java.util.List;

public class DatabaseDaoServiceImpl implements DatabaseDaoService {

    @Override
    public void put(Products product, Integer amount) {
        Product productToAdd = Product.productsMap.get(product);
        productToAdd.setAmount(amount);
        DataBase.database.add(productToAdd);
    }

    @Override
    public void reduceAmount(Products product, Integer amount) {
        DataBase.database.stream()
                .filter(dataProduct -> dataProduct.getType() == product)
                .forEach(dataProduct -> dataProduct.subtractAmount(amount));
    }

    @Override
    public void increaseAmount(Products product, Integer amount) {
        DataBase.database.stream()
                .filter(dataProduct -> dataProduct.getType() == product)
                .forEach(dataProduct -> dataProduct.addAmount(amount));
    }

    @Override
    public List<Product> getAll() {
        return List.copyOf(DataBase.database);
    }
}
