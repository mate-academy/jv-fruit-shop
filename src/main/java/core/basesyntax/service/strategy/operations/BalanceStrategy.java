package core.basesyntax.service.strategy.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceStrategy implements OperationHandler {
    private static final ProductDao productDao = new ProductDaoImpl();

    @Override
    public int handle(FruitTransaction transaction) {
        return productDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
