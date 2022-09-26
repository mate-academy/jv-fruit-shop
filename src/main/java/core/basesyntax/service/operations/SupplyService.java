package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class SupplyService implements OperationHandler {
    /**
     * Add some amount of some fruits to storage
     */
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        int beginAmount = fruitDao.getAmount(fruitTransaction.getFruit());
        int newAmount;
        newAmount = beginAmount + fruitTransaction.getQuantity();
        fruitDao.changeAmount(fruitTransaction.getFruit(), newAmount);
    }
}
