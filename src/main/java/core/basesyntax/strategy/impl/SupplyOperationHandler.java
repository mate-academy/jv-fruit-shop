package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;
    
    public SupplyOperationHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Integer currentQuantity = fruitDao.getQuantity(transaction.getName());
        Integer newQuantity = ((currentQuantity == null) ? 0 : currentQuantity) 
                + transaction.getQuantity();
        fruitDao.replaceValue(transaction.getName(), newQuantity);
    }
}
