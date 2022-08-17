package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class FruitReturn implements FruitOperation {
    private final FruitDao fruitDao;

    public FruitReturn(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int amount = fruitDao.getQuantity(fruit);
        int returns = fruitTransaction.getQuantity();
        fruitDao.addFruit(fruit, amount + returns);
    }
}
