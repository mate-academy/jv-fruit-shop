package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantityToReturn = transaction.getQuantity();
        int currentQuantity = fruitDao.get(fruitName);
        int newQuantity = currentQuantity + quantityToReturn;
        fruitDao.update(fruitName, newQuantity);
    }
}
