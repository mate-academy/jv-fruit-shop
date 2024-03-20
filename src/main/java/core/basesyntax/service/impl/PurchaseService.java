package core.basesyntax.service.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.exceptions.NotEnoughFruitsException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseService implements OperationHandler {
    private final ProductDao productDao;

    public PurchaseService() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public int handle(FruitTransaction transaction) {
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
