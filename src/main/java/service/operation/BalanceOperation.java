package service.operation;

import database.Storage;
import database.dao.FruitDao;
import database.dao.FruitDaoImpl;
import model.FruitTransaction;
import service.exception.InvalidDataException;

public class BalanceOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperation() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        if (Storage.STORAGE.containsKey(fruitTransaction.getName())) {
            throw new InvalidDataException("Balance for '" + fruitTransaction.getName()
                        + "' is already set");
        }
        fruitDao.add(fruitTransaction.getName(), fruitTransaction.getQuantity());
    }
}
