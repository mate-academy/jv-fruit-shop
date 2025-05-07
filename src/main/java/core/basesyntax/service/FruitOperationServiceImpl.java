package core.basesyntax.service;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.model.FruitOperation;

public class FruitOperationServiceImpl implements FruitOperationService {
    private FruitOperationDao fruitOperationDao;

    public FruitOperationServiceImpl(FruitOperationDao fruitOperationDao) {
        this.fruitOperationDao = fruitOperationDao;
    }

    @Override
    public void createNewFruitOperation(String fruit) {
        FruitOperation fruitOperation = new FruitOperation();
        fruitOperation.setFruit(fruit);
        fruitOperationDao.add(fruitOperation);
    }
}
