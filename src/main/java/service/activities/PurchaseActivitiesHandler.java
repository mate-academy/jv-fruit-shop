package service.activities;

import db.FruitShop;
import model.FruitTransaction;

public class PurchaseActivitiesHandler implements ActivitiesHandler {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        FruitShop.fruitShop.remove(fruitTransaction);
    }
}
