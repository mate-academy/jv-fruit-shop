package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyService implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int beginAmount = fruitDao.getAmount(fruitTransaction.getFruit());
        int newAmount;
        newAmount = beginAmount + fruitTransaction.getQuantity();
        fruitDao.changeAmount(fruitTransaction.getFruit(), newAmount);
    }
}
