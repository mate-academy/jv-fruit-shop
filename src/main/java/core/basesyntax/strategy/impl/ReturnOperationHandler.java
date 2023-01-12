package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitAccountingDao;
import core.basesyntax.dao.FruitAccountingDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private FruitAccountingDao fruitAccountingDao;

    @Override
    public void handle(FruitTransaction transaction) {
        fruitAccountingDao = new FruitAccountingDaoImpl();
        Integer currentQuantity = fruitAccountingDao.getQuantity(transaction.getFruit());
        Integer newQuantity = currentQuantity + transaction.getQuantity();
        fruitAccountingDao.updateQuantity(transaction.getFruit(), newQuantity);
    }
}
