package core.basesyntax.service.activity.activityImpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.activity.Activity;

public class Balance implements Activity {
    private final int amount;
    private final String fruitName;

    public Balance(String fruitName, int amount) {
        this.amount = amount;
        this.fruitName = fruitName;
    }

    @Override
    public Integer execute(Storage storage) {
        return storage.setAmount(fruitName, amount);
    }
}
