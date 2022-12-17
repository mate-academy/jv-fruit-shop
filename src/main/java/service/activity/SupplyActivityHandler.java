package service.activity;

import dao.FruitStorageDao;
import model.Fruit;
import model.FruitTransaction;

public class SupplyActivityHandler implements ActivityHandler {
    private FruitStorageDao fruitStorageDao;

    public SupplyActivityHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean handle(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        Integer supplyAmount = fruitTransaction.getAmount();
        if (fruitStorageDao.getAmountByFruit(fruit) == null) {
            return fruitStorageDao.add(fruit, supplyAmount);
        }
        return fruitStorageDao.update(fruit,
                fruitStorageDao.getAmountByFruit(fruit) + supplyAmount);
    }
}
