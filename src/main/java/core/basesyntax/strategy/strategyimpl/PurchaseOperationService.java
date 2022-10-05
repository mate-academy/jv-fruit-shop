package core.basesyntax.strategy.strategyimpl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class PurchaseOperationService implements OperationService {
    private FruitDao fruitDao;

    public PurchaseOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void executeOperation(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer fruitQuantity = fruitDao.getQuantity(fruit);
        Integer purchaseQuantity = transaction.getQuantity();
        if (fruitQuantity - purchaseQuantity < 0) {
            throw new RuntimeException("You have only " + fruitQuantity + " fruits");
        }
        fruitDao.update(fruit, fruitQuantity - purchaseQuantity);
    }
}
