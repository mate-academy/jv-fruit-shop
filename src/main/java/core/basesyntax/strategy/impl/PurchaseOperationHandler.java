package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.impl.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        productDao.subtractAmount(transaction.getFruit(), transaction.getQuantity());
    }
}
