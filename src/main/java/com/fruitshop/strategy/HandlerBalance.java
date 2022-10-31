package com.fruitshop.strategy;

import com.fruitshop.servicesimpl.DataBaseManagerImpl;

public class HandlerBalance implements Handler {
    private DataBaseManagerImpl data = new DataBaseManagerImpl();

    @Override
    public void putInDb(String key, String value) {
        data.getFromDB(key)
                .setBalance(data.getFromDB(key)
                        .getBalance() + Integer.parseInt(value));
    }
}
