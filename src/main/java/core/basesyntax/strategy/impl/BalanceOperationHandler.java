package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.impl.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public BalanceOperationHandler() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public void apply(FruitTransaction transaction) {
        productDao.updateAmount(transaction.getFruit(), transaction.getQuantity());
    }
}
