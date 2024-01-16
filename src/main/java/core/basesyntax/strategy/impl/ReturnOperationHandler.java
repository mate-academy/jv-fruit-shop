package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationsHandler;

public record ReturnOperationHandler(FruitDao fruitDao) implements OperationsHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer newBalance = calculateReturnResult(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
        fruitDao.putToStorage(fruitTransaction.getFruit(), newBalance);
    }

    private int calculateReturnResult(String fruit, int quantity) {
        int currentBalance = fruitDao.getQualityByItemType(fruit);
        return currentBalance + quantity;
    }
}
