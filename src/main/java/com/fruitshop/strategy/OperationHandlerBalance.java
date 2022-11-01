package com.fruitshop.strategy;

import com.fruitshop.dao.FruitDaoImpl;

public class OperationHandlerBalance implements OperationHandler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void handle(String key, String value) {
        fruitDao.get(key)
                .setBalance(fruitDao.get(key)
                        .getBalance() + Integer.parseInt(value));
    }
}
