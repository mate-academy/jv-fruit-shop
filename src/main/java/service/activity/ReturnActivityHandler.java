package service.activity;

import dao.FruitStorageDao;
import model.FruitTransaction;

public class ReturnActivityHandler implements ActivityHandler {
    private FruitStorageDao fruitStorageDao;

    public ReturnActivityHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean handle(FruitTransaction fruitTransaction) {
        return fruitStorageDao.update(fruitTransaction.getFruit(),
                fruitStorageDao.getAmountByFruit(fruitTransaction.getFruit())
                        + fruitTransaction.getAmount());
    }
}
