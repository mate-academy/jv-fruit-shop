package service.impl;

import model.FruitTransaction;
import service.FruitService;

public class FruitServiceImpl implements FruitService {
    public FruitServiceImpl() {
    }

    @Override
    public FruitTransaction createNewFruit(String name, int quantity) {
        return new FruitTransaction(name, quantity);
    }
}
