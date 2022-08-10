package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(String fruit, Integer quantity) {
        if (fruitDao.getQuantity(fruit) > 0) {
            System.out.println("There are more the one of balance data on fruit " + fruit);
        }
        fruitDao.add(fruit, quantity);
    }
}
