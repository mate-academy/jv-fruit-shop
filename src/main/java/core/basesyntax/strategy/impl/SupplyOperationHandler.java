package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Fruit performOperation(FruitTransaction fruitTransaction) {
        FruitDao fruitDao = new FruitDaoImpl();
        
        Integer quantity = fruitDao.getByName(fruitTransaction);
        return new Fruit(fruitTransaction.getName(), quantity + fruitTransaction.getQuantity());
    }
}
