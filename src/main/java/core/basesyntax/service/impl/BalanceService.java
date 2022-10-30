package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class BalanceService implements OperationService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        fruitDao.add(new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity()));
    }
}
