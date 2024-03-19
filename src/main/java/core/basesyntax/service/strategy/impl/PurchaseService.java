package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.exceptions.NotEnoughFruitsException;
import core.basesyntax.service.strategy.ActivityService;
import core.basesyntax.utility.FruitTransaction;

public class PurchaseService implements ActivityService {
    private final ProductDao productDao;

    public PurchaseService() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public int execute(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int newFruitNumber = productDao.getValue(fruitName) - transaction.getQuantity();

        if (newFruitNumber < 0) {
            throw new NotEnoughFruitsException("Not enough fruits to buy "
                    + transaction.getQuantity()
                    + " " + fruitName);
        }
        return productDao.add(fruitName, newFruitNumber);
    }
}
