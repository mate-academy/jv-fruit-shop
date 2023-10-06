package service.activities;

import model.FruitTransaction;

public interface ActivitiesHandler {
    //викон операцію і записати в fruitShop
    void executeTransaction(FruitTransaction fruitTransaction);
}
