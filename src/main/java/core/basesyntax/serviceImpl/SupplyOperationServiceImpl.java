package core.basesyntax.serviceImpl;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.serviceOperate.OperationHandlerService;

public class SupplyOperationServiceImpl implements OperationHandlerService {
    private FruitOperationDao fruitOperationDao;

    public SupplyOperationServiceImpl(FruitOperationDao fruitOperationDao) {
        this.fruitOperationDao = fruitOperationDao;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitOperationDao.get(fruit);
        quantity += fruitTransaction.getQuantity();
        fruitOperationDao.put(fruit, quantity);
    }
}
