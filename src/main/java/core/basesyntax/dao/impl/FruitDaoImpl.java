package core.basesyntax.dao.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.dao.FruitDao;

public class FruitDaoImpl implements FruitDao {
    private static final String MESSAGE_FRUIT_NOT_AVAILABLE = "The requested fruit is "
            + "currently unavailable.";
    private static final String MESSAGE_NOT_ENOUGH_FRUIT = "We do not have sufficient "
            + "quantity of the requested fruit.";
    private static final String EXCEPTION_MESSAGE = "Quantity is not valid";

    public void supplyFruit(String fruit, int quantity) {
        var balanceOfQuantity = storage.get(fruit);
        if (storage.containsKey(fruit)) {
            storage.replace(fruit, balanceOfQuantity + quantity);
        } else {
            storage.put(fruit, quantity);
        }
    }

    @Override
    public void boughtFruit(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        if (!storage.containsKey(fruit)) {
            throw new RuntimeException(MESSAGE_FRUIT_NOT_AVAILABLE + fruit);
        }
        var balanceOfQuantity = storage.get(fruit);
        if (balanceOfQuantity < quantity) {
            throw new RuntimeException(MESSAGE_NOT_ENOUGH_FRUIT + fruit);
        }
        storage.replace(fruit, balanceOfQuantity - quantity);
    }

    @Override
    public void returnFruit(String fruit, int quantity) {
        supplyFruit(fruit, quantity);
    }
}
