package com.fruitshop.strategy;

import com.fruitshop.dao.FruitDaoImpl;

public class HandlerReturned implements Handler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void putInDb(String key, String value) {
        fruitDao.get(key)
                .setReturned(fruitDao.get(key)
                        .getReturned() + Integer.parseInt(value));
    }
}
