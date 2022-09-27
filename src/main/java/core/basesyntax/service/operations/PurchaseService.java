package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseService implements OperationHandler {
    private final FruitDao fruitDao;
    public PurchaseService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int beginAmount;
        int newAmount;
        beginAmount = fruitDao.getAmount(fruitTransaction.getFruit());
        if (fruitTransaction.getQuantity() > beginAmount) {
            throw new RuntimeException(
                    "Impossible transaction. There aren`t needed value of fruits");
        } else {
            newAmount = beginAmount - fruitTransaction.getQuantity();
        }
        fruitDao.changeAmount(fruitTransaction.getFruit(), newAmount);
    }
}
