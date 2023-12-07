package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(String fruit, Integer quantity) {
        fruitDao.add(fruit, fruitDao.get(fruit) - quantity);
        System.out.println("Fruit: " + fruit + " PurchaseOperationHandler: " + fruitDao.get(fruit));
    }
}