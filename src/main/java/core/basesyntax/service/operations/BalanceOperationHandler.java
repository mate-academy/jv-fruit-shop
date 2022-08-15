package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        Integer quantityInStorage = fruitDao.get(transaction.getFruit());
        if (quantityInStorage != null) {
            fruitDao.add(transaction.getFruit(), quantityInStorage + transaction.getQuantity());
        } else {
            fruitDao.add(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
