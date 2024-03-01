package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnActivityHandler implements ActivityHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction, FruitDao fruitDao) {
        fruitDao.add(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
    }
}
