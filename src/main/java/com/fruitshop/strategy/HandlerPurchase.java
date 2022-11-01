package com.fruitshop.strategy;

import com.fruitshop.dao.FruitDaoImpl;

public class HandlerPurchase implements Handler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void putInDb(String key, String value) {
        fruitDao.get(key)
                .setPurchase(fruitDao.get(key)
                        .getPurchase() + Integer.parseInt(value));
    }
}
