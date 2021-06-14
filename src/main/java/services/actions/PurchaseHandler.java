package services.actions;

import db.Storage;

public class PurchaseHandler implements ActionHandler {
    @Override
    public void getResultOfAction(String fruitName, int fruitCount) {
        Storage.fruits.put(
                fruitName, Storage.fruits.getOrDefault(
                        fruitName, 0) - fruitCount);
    }
}
