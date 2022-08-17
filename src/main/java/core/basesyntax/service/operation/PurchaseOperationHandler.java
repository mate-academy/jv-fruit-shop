package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processOperation(FruitTransaction transaction) {
        int negativeQuantity = - transaction.getQuantity();
        if ((fruitDao.getQuantity(transaction.getFruit()) - transaction.getQuantity()) >= 0) {
            fruitDao.merge(transaction.getFruit(), negativeQuantity);
        } else {
            throw new RuntimeException(
                    "Invalid purchase value. Purchase value should be <= "
                    + fruitDao.getQuantity(transaction.getFruit()));
        }
    }
}
