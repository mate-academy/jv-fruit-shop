package operation.handlerimpl;

import dao.FruitStorageDao;
import model.FruitTransaction;
import operation.OperationHendler;

public class SupplyHandlerImpl implements OperationHendler {
    private FruitStorageDao fruitStorageDao;

    public SupplyHandlerImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void calculateQuantity(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = fruitStorageDao.getFruitQuantity(fruit);
        int amount = transaction.getAmount();
        fruitStorageDao.updateFruitQuantity(fruit, quantity + amount);

    }
}
