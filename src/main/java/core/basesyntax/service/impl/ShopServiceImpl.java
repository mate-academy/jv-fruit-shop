package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitInStorage;
import core.basesyntax.service.ShopService;

public class ShopServiceImpl implements ShopService {
    private static final Storage STORAGE = new Storage();

    @Override
    public FruitInStorage addFruits(String fruit, int amount) {
        FruitInStorage product = STORAGE.getByName(fruit);
        if (product == null) {
            product = new FruitInStorage(fruit, amount);
            STORAGE.add(product);
            return product;
        }
        int newAmount = product.getAmount() + amount;
        STORAGE.update(product, newAmount);
        return product;
    }

    @Override
    public FruitInStorage removeFruits(String fruit, int amount) {
        FruitInStorage product = STORAGE.getByName(fruit);
        if (product == null) {
            return null;
        }
        int newAmount = product.getAmount() - amount;
        if (newAmount < 0) {
            throw new RuntimeException("We don't have that much " + product.getName());
        }
        STORAGE.update(product, newAmount);
        return product;
    }
}
