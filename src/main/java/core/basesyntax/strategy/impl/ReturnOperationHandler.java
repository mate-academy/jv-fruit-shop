package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.exception.MyOwnException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.math.BigDecimal;

public class ReturnOperationHandler implements OperationHandler {
    private FruitDao fruitDao;
    private FruitTransactionDao fruitTransactionDao;

    public ReturnOperationHandler(FruitDao fruitDao, FruitTransactionDao fruitTransactionDao) {
        this.fruitDao = fruitDao;
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void completeOperation(String fruitName, BigDecimal quantity) { // TODO:
        FruitTransaction fruitTransactionFromDb = fruitTransactionDao.get(fruitName, quantity);
        if (fruitTransactionFromDb != null) {
            Fruit fruitFromDb = fruitDao.get(fruitName);
            BigDecimal newQuantity = fruitFromDb.getQuantity().add(quantity);
            fruitFromDb.setQuantity(newQuantity);
            fruitDao.update(fruitFromDb);
        } else {
            throw new MyOwnException("There isn't such fruit transaction in the storage:"
                    + fruitName + ", " + quantity);
        }
    }
}
