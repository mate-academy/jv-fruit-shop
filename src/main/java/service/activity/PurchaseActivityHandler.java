package service.activity;

import dao.FruitStorageDao;
import model.Fruit;
import model.FruitTransaction;

public class PurchaseActivityHandler implements ActivityHandler {
    private FruitStorageDao fruitStorageDao;

    public PurchaseActivityHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean handle(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        Integer purchaseAmount = fruitTransaction.getAmount();
        if (fruitStorageDao.getAmountByFruit(fruit) == null) {
            throw new RuntimeException("Missing information about fruit balance, fruit: "
                    + fruit.getName());
        } else if (fruitStorageDao.getAmountByFruit(fruit).compareTo(purchaseAmount) < 0) {
            throw new RuntimeException("The purchase can't be more than the amount, amount: "
                    + fruitStorageDao.getAmountByFruit(fruit) + ", purchase: " + purchaseAmount);
        }
        return fruitStorageDao.update(fruit,
                fruitStorageDao.getAmountByFruit(fruit) - purchaseAmount);
    }
}
