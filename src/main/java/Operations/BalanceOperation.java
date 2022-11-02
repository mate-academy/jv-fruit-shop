package Operations;

import DAO.DAOFruit;
import core.basesyntax.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final DAOFruit fruitDao;

    public BalanceOperation(DAOFruit fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.addFruits(fruitTransaction.getFruit(), fruitTransaction.getAmount());
    }
}
