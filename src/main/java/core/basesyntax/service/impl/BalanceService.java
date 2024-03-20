package core.basesyntax.service.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceService implements OperationHandler {
    private final ProductDao productDao;

    public BalanceService() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public int handle(FruitTransaction transaction) {
        return productDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
