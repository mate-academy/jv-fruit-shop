package core.basesyntax.service.activity.activityImpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.activity.Activity;

public class Return implements Activity {
    private final int amount;
    private final String fruitName;

    public Return(String fruitName, int amount) {
        this.amount = amount;
        this.fruitName = fruitName;
    }

    @Override
    public Integer execute(Storage storage) {
        int newAmount = storage.getAmount(fruitName) + amount;
        return storage.setAmount(fruitName, newAmount);
    }
}
