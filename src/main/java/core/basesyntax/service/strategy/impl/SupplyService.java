package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.service.strategy.ActivityService;
import core.basesyntax.utility.FruitTransaction;

public class SupplyService implements ActivityService {
    private final ProductDao productDao;

    public SupplyService() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public int execute(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int newFruitNumber = productDao.getValue(fruitName) + transaction.getQuantity();
        return productDao.add(fruitName, newFruitNumber);
    }
}
