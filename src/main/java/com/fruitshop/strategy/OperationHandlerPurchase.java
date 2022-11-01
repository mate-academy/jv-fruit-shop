package com.fruitshop.strategy;

import com.fruitshop.dao.FruitDaoImpl;

public class OperationHandlerPurchase implements OperationHandler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void handle(String key, String value) {
        fruitDao.get(key)
                .setPurchase(fruitDao.get(key)
                        .getPurchase() + Integer.parseInt(value));
    }
}
