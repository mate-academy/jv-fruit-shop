package com.fruitshop.strategy;

import com.fruitshop.dao.DataBaseManagerImpl;

public class HandlerPurchase implements Handler {
    private DataBaseManagerImpl data = new DataBaseManagerImpl();

    @Override
    public void putInDb(String key, String value) {
        data.getFromDB(key)
                .setPurchase(data.getFromDB(key)
                        .getPurchase() + Integer.parseInt(value));
    }
}
