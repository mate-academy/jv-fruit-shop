package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;
import service.impl.FruitServiceImpl;

public class BalanceOperation implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperation() {
        this.fruitDao = new FruitDaoImpl(new FruitServiceImpl());
    }

    @Override
    public FruitTransaction operate(FruitTransaction fruitTransaction) {
        return fruitDao.add(fruitTransaction);
    }
}
