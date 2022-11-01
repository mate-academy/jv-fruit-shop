package com.fruitshop.strategy;

import com.fruitshop.dao.FruitDaoImpl;

public class HandlerBalance implements Handler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void putInDb(String key, String value) {
        fruitDao.get(key)
                .setBalance(fruitDao.get(key)
                        .getBalance() + Integer.parseInt(value));
    }
}
