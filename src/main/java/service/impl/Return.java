package service.impl;

import service.StoreActivities;

public class Return implements StoreActivities {
    @Override
    public int getFruitAmount(int fruitAmount) {
        return fruitAmount;
    }
}
