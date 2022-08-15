package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        Integer quantityInStorage = fruitDao.get(transaction.getFruit());
        if (quantityInStorage == null || quantityInStorage - transaction.getQuantity() < 0) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " in shop.");
        } else {
            fruitDao.add(transaction.getFruit(), quantityInStorage - transaction.getQuantity());
        }

    }
}
