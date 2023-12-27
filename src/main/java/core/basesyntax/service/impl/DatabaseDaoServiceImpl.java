package core.basesyntax.service.impl;

import core.basesyntax.constants.Product;
import core.basesyntax.db.Database;
import core.basesyntax.products.Goods;
import core.basesyntax.service.DatabaseDaoService;
import java.util.List;
import java.util.Optional;

public class DatabaseDaoServiceImpl implements DatabaseDaoService {
    @Override
    public void put(Product product, Integer amount) {
        Goods goodsToAdd = Goods.productsMap.get(product);
        goodsToAdd.setAmount(amount);
        Database.database.add(goodsToAdd);
    }

    @Override
    public void reduceAmount(Product product, Integer amount) {
        Database.database.stream()
                .filter(dataProduct -> dataProduct.getType() == product)
                .forEach(dataProduct -> dataProduct.subtractAmount(amount));
    }

    @Override
    public void increaseAmount(Product product, Integer amount) {
        Database.database.stream()
                .filter(dataProduct -> dataProduct.getType() == product)
                .forEach(dataProduct -> dataProduct.addAmount(amount));
    }

    @Override
    public List<Goods> getAll() {
        return List.copyOf(Database.database);
    }

    @Override
    public Goods getProduct(Product product) {
        Optional<Goods> requiredProduct = Database.database.stream()
                .filter(productElm -> productElm.getType() == product)
                .findFirst();
        if (requiredProduct.isPresent()) {
            return requiredProduct.get();
        } else {
            throw new RuntimeException("There is no product " + product + " in database");
        }
    }
}
