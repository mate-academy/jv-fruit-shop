package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.FruitList;

public class Purchase implements OperationService {
    StorageDaoImpl storageDao = new StorageDaoImpl();
    FruitList fruitList = new FruitList();

    @Override
    public Integer operate(String fruitName, String value) {
        Fruit fruit = fruitList.getFruitByName(fruitName);
        //System.out.println(fruits);
        int fruitsQuantity = Integer.parseInt(value);
        int currentQuantity = storageDao.getCurrentQuantity(fruitName);
        fruit.setQuantity(currentQuantity - fruitsQuantity);
        return storageDao.update(fruitName, currentQuantity - fruitsQuantity);
    }
}
