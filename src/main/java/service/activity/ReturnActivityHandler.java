package service.activity;

import dao.FruitStorageDao;
import model.Fruit;
import model.FruitTransaction;

public class ReturnActivityHandler implements ActivityHandler {
    private FruitStorageDao fruitStorageDao;

    public ReturnActivityHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean handle(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        Integer returnAmount = fruitTransaction.getAmount();
        if (fruitStorageDao.getAmountByFruit(fruit) == null) {
            return fruitStorageDao.add(fruit, returnAmount);
        }
        return fruitStorageDao.update(fruit,
                fruitStorageDao.getAmountByFruit(fruit) + returnAmount);
    }
}
