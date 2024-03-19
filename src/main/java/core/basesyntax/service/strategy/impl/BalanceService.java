package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.service.strategy.ActivityService;
import core.basesyntax.utility.FruitTransaction;

public class BalanceService implements ActivityService {
    private final ProductDao productDao;

    public BalanceService() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public int execute(FruitTransaction transaction) {
        return productDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
