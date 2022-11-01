package com.fruitshop.strategy;

import com.fruitshop.dao.FruitDaoImpl;

public class HandlerSupply implements Handler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void putInDb(String key, String value) {
        fruitDao.get(key)
                .setSupply(fruitDao.get(key)
                        .getSupply() + Integer.parseInt(value));
    }
}
