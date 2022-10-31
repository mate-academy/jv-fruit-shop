package com.fruitshop.strategy;

import com.fruitshop.servicesimpl.DataBaseManagerImpl;

public class HandlerSupply implements Handler {
    private DataBaseManagerImpl data = new DataBaseManagerImpl();

    @Override
    public void putInDb(String key, String value) {
        data.getFromDB(key)
                .setSupply(data.getFromDB(key)
                        .getSupply() + Integer.parseInt(value));
    }
}
