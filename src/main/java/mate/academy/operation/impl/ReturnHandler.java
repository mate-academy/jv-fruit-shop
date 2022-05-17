package mate.academy.operation.impl;

import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.FruitTransaction;
import mate.academy.operation.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void getHandler(FruitTransaction fruitTransaction) {
        FruitTransaction fruitTransactionInDB = fruitDao.get(fruitTransaction.getFruit());
        if (fruitTransactionInDB == null) {
            fruitDao.add(fruitTransaction);
        } else {
            int total = fruitTransactionInDB.getQuantity() + fruitTransaction.getQuantity();
            fruitTransactionInDB.setQuantity(total);
            fruitDao.add(fruitTransactionInDB);
        }
    }
}
