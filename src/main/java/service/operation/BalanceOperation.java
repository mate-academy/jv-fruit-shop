package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction.getName(), fruitTransaction.getQuantity());
    }
}
