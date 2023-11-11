package operation.handlerimpl;

import dao.FruitStorageDao;
import exception.NegativeBalanceException;
import model.FruitTransaction;
import operation.OperationHendler;

public class PurshaseHandlerImpl implements OperationHendler {
    private static final int EMPTY_STORAGE_VALUE = 0;
    private FruitStorageDao fruitStorageDao;

    public PurshaseHandlerImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void calculateQuantity(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = fruitStorageDao.getFruitQuantity(transaction.getFruit());
        int amunt = transaction.getAmount();
        if (quantity == EMPTY_STORAGE_VALUE) {
            throw new IllegalStateException("Can`t purshase because storage is empty");
        }

        if (quantity < amunt) {
            throw new NegativeBalanceException("Balance is can`t be negative");
        }
        fruitStorageDao.updateFruitQuantity(fruit, quantity - amunt);
    }
}
