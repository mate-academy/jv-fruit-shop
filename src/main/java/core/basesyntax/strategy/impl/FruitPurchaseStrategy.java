package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.exception.GoodsLessQuantityException;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateStrategy;
import java.util.NoSuchElementException;

public class FruitPurchaseStrategy implements StorageUpdateStrategy {
    private static final String SEARCHING_FAILURE_MESSAGE = "Can`t find product {%s} in storage";
    private static final String PURCHASING_FAILURE_MESSAGE = "Amount of purchased"
            + " {%s} cannot be more than product amount!";
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void updateStorage(String fruit, int amount) {
        checkAbilityToUpdate(fruit, amount);
        fruitDao.remove(fruit, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return operationCode.equals(Operation.PURCHASE.getCode());
    }

    private void checkAbilityToUpdate(String fruit, int amount) {
        if (fruitDao.get(fruit) == null) {
            throw new NoSuchElementException(String
                    .format(SEARCHING_FAILURE_MESSAGE, fruit));
        }
        if (fruitDao.get(fruit) < amount) {
            throw new GoodsLessQuantityException(String
                    .format(PURCHASING_FAILURE_MESSAGE, fruit));
        }
    }
}
