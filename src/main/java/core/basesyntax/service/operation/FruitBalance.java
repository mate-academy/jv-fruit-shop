package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class FruitBalance implements FruitOperation {
    private final FruitDao fruitDao;

    public FruitBalance(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        fruitDao.addFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
