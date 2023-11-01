package activity.impl;

import activity.ActivityHandler;
import db.Storage;

public class Balance implements ActivityHandler {
    @Override
    public void accept(String fruit, int amount) {
        Storage.setAmount(fruit, amount);
    }
}
