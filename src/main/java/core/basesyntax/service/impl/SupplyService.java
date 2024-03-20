package core.basesyntax.service.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplyService implements OperationHandler {
    private final ProductDao productDao;

    public SupplyService() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public int handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int newFruitNumber = productDao.getValue(fruitName) + transaction.getQuantity();
        return productDao.add(fruitName, newFruitNumber);
    }
}
