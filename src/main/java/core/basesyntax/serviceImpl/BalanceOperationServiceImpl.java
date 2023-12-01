package core.basesyntax.serviceImpl;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.serviceOperate.OperationHandlerService;

public class BalanceOperationServiceImpl implements OperationHandlerService {
    private FruitOperationDao fruitOperationDao;

    public BalanceOperationServiceImpl(FruitOperationDao fruitOperationDao) {
        this.fruitOperationDao = fruitOperationDao;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        fruitOperationDao.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
