package service.activities;

import db.FruitShop;
import model.FruitTransaction;

public class ReturnActivitiesHandler implements ActivitiesHandler {
    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        FruitShop.fruitShop.add(fruitTransaction);
    }
}
