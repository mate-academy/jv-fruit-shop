package operations;

import dao.DaoFruit;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final DaoFruit fruitDao;

    public BalanceOperation(DaoFruit fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.addFruits(fruitTransaction.getFruit(), fruitTransaction.getAmount());
    }
}
