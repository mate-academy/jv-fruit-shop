package core.basesyntax.service.strategy.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnStrategy implements OperationHandler {
    private static final ProductDao productDao = new ProductDaoImpl();

    @Override
    public int handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int newFruitNumber = productDao.getValue(fruitName) + transaction.getQuantity();
        return productDao.add(fruitName, newFruitNumber);
    }
}
