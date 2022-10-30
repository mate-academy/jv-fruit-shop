package com.fruitshop.strategy;

import com.fruitshop.servicesimpl.DataBaseManagerImpl;

public class HandlerReturned implements Handler {
    private DataBaseManagerImpl data = new DataBaseManagerImpl();

    @Override
    public void putInDb(String key, String value) {
        data.getFromDB(key).setReturned(Integer.parseInt(value));
    }
}
