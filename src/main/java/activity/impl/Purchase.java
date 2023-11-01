package activity.impl;

import activity.ActivityHandler;
import db.Storage;

public class Purchase implements ActivityHandler {

    @Override
    public void accept(String fruit, int number) {
        Storage.addFruit(fruit, -number);
    }
}
