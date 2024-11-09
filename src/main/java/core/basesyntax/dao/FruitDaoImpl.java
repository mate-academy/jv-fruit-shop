package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    private static final String MESSAGE_FRUIT_NOT_AVAILABLE = "Sorry, but we don't have ";
    private static final String MESSAGE_QUANTITY_NOT_ENOUGH = "We don't have enough quantity ";
    private final Storage storage;

    public FruitDaoImpl(Storage storage) {
        this.storage = storage;
    }

    public void supplyFruit(String fruit, int quantity) {
        var balanceOfQuantity = storage.getStorage().get(fruit);
        if (storage.getStorage().containsKey(fruit)) {
            storage.getStorage().replace(fruit, balanceOfQuantity + quantity);
        } else {
            storage.getStorage().put(fruit, quantity);
        }
    }

    @Override
    public void boughtFruit(String fruit, int quantity) {
        var balanceOfQuantity = storage.getStorage().get(fruit);
        if (!storage.getStorage().containsKey(fruit)) {
            System.out.println(MESSAGE_FRUIT_NOT_AVAILABLE + fruit);
            return;
        } else if (storage.getStorage().get(fruit) >= quantity) {
            storage.getStorage().replace(fruit, balanceOfQuantity - quantity);
            return;
        }
        System.out.println(MESSAGE_QUANTITY_NOT_ENOUGH + fruit);
    }

    @Override
    public void returnFruit(String fruit, int quantity) {
        supplyFruit(fruit, quantity);
    }
}
