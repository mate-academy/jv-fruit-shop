package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.exception.GoodsLessQuantityException;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StorageUpdateHandler;
import java.util.NoSuchElementException;

public class FruitPurchaseStrategy implements StorageUpdateHandler {
    private static final String SEARCHING_FAILURE_MESSAGE = "Can`t find product {%s} in storage";
    private static final String PURCHASING_FAILURE_MESSAGE = "Amount of purchased"
            + " {%s} cannot be more than product amount!";
    private final FruitDao fruitDao;

    public FruitPurchaseStrategy() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void updateStorage(String fruit, int amount) {
        checkAbilityToUpdate(fruit, amount);
        fruitDao.remove(fruit, amount);
    }

    @Override
    public boolean isServiceApplicable(String operationCode) {
        return Operation.PURCHASE.getCode().equals(operationCode);
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
