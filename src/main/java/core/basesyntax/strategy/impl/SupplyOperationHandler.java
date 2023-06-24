package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.impl.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public SupplyOperationHandler() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public void apply(FruitTransaction transaction) {
        productDao.addAmount(transaction.getFruit(), transaction.getQuantity());
    }
}
