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
        Integer currentAmount = fruitStorageDao.getAmountByFruit(fruit);
        if (fruitStorageDao.getAmountByFruit(fruit) == null
                || currentAmount.compareTo(purchaseAmount) < 0) {
            throw new RuntimeException("Missing information about fruit balance "
                    + "or wrong purchase amount, fruit: "
                    + fruit.getName() + ", amount: " + currentAmount
                    + ", purchase: " + purchaseAmount);
        }
        return fruitStorageDao.update(fruit,currentAmount - purchaseAmount);
    }
}
