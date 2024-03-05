package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseActivityHandler implements ActivityHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction, FruitDao fruitDao) {
        Integer balance = fruitDao.add(fruitTransaction.getFruitName(),
                -fruitTransaction.getQuantity());
        if (balance < 0) {
            throw new RuntimeException("Balance is negative after activity in class "
                    + this.getClass().getSimpleName());
        }
    }
}
