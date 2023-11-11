package operation.handlerimpl;

import dao.FruitStorageDao;
import model.FruitTransaction;
import operation.OperationHendler;

public class ReturnHandlerImpl implements OperationHendler {
    private FruitStorageDao fruitStorageDao;

    public ReturnHandlerImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void calculateQuantity(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int amount = transaction.getAmount();
        int quantity = fruitStorageDao.getFruitQuantity(fruit);
        fruitStorageDao.updateFruitQuantity(fruit, quantity + amount);
    }
}
