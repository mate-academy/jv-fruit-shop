package services.actions;

import db.Storage;

public class BalanceHandler implements ActionHandler {
    @Override
    public void getResultOfAction(String fruitName, int fruitCount) {
        Storage.fruits.put(fruitName, fruitCount);
    }
}
