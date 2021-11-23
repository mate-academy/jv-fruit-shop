package core.basesyntax.service.activity.activityimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.activity.Activity;

public class Purchase implements Activity {
    private final int amount;
    private final String fruitName;

    public Purchase(String fruitName, int amount) {
        this.amount = amount;
        this.fruitName = fruitName;
    }

    @Override
    public Integer execute(Storage storage) {
        int newAmount = storage.getAmount(fruitName) - amount;
        if (newAmount < 0) {
            throw new RuntimeException("Not enough " + fruitName);
        }
        return storage.setAmount(fruitName, newAmount);
    }
}
