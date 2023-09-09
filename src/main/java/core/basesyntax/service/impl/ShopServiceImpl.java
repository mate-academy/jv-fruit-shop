package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitInStorage;
import core.basesyntax.service.ShopService;

public class ShopServiceImpl implements ShopService {
    private static final FruitDao FRUIT_DAO = new FruitDaoImpl();

    @Override
    public FruitInStorage addFruits(String fruit, int amount) {
        FruitInStorage product = FRUIT_DAO.getByName(fruit);
        if (product == null) {
            product = new FruitInStorage(fruit, amount);
            FRUIT_DAO.add(product);
            return product;
        }
        int newAmount = product.getAmount() + amount;
        FRUIT_DAO.update(product, newAmount);
        return product;
    }

    @Override
    public FruitInStorage removeFruits(String fruit, int amount) {
        FruitInStorage product = FRUIT_DAO.getByName(fruit);
        if (product == null) {
            return null;
        }
        int newAmount = product.getAmount() - amount;
        if (newAmount < 0) {
            throw new RuntimeException("We don't have that much " + product.getName());
        }
        FRUIT_DAO.update(product, newAmount);
        return product;
    }
}
