package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(String fruit, Integer quantity) {
        fruitDao.add(fruit, quantity);
        System.out.println("Fruit: " + fruit + " BalanceOperationHandler: " + fruitDao.get(fruit));
    }
}
