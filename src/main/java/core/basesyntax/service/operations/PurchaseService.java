package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseService implements Operations {
    /**
     * Take some amount of some fruits from storage
     */
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void realization(FruitTransaction fruitTransaction) {
        int beginAmount;
        int newAmount;
        beginAmount = fruitDao.getFruitAmount(fruitTransaction);
        if (fruitTransaction.getQuantity() > beginAmount) {
            throw new RuntimeException(
                    "Impossible transaction. There aren`t needed value of fruits");
        } else {
            newAmount = beginAmount - fruitTransaction.getQuantity();
        }
        fruitDao.changeAmount(fruitTransaction, newAmount);
    }
}
