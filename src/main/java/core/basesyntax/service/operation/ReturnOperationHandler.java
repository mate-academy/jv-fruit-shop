package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit updateStorage(FruitTransaction fruitTransaction) {
        Fruit fruitFromTransaction = fruitTransaction.getFruit();
        Fruit fruitFromStorage = fruitDao.getFruit(fruitFromTransaction.getName());
        fruitFromStorage.setAmount(fruitFromTransaction.getAmount()
                + fruitFromStorage.getAmount());
        return fruitFromStorage;
    }
}
