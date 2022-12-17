package service.activity;

import dao.FruitStorageDao;
import model.FruitTransaction;

public class BalanceActivityHandler implements ActivityHandler {
    private FruitStorageDao fruitStorageDao;

    public BalanceActivityHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean handle(FruitTransaction fruitTransaction) {
        if (fruitStorageDao.getAmountByFruit(fruitTransaction.getFruit()) != null) {
            throw new RuntimeException("Balance information about fruit already has, fruit: "
                    + fruitTransaction.getFruit().getName());
        }
        return fruitStorageDao.add(fruitTransaction.getFruit(), fruitTransaction.getAmount());
    }
}
