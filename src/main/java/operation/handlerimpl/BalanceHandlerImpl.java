package operation.handlerimpl;

import dao.FruitStorageDao;
import model.FruitTransaction;
import operation.OperationHendler;

public class BalanceHandlerImpl implements OperationHendler {
    private static FruitStorageDao fruitStorageDao;

    public BalanceHandlerImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void calculateQuantity(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int amount = transaction.getAmount();
        fruitStorageDao.updateFruitQuantity(fruit, amount);
    }
}
