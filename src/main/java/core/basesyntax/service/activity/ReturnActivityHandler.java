package core.basesyntax.service.activity;

import core.basesyntax.model.FruitTransaction;

public class ReturnActivityHandler implements ActivityHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        fruitDao.update(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
    }
}
