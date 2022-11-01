package com.fruitshop.services;

import com.fruitshop.dao.FruitDaoImpl;

public interface ResultMessage {
    String makeMessage(FruitDaoImpl fruitDao);
}
