package service.impl;

import model.Fruit;
import service.FruitService;

public class FruitServiceImpl implements FruitService {
    public FruitServiceImpl() {
    }

    @Override
    public Fruit createNewFruit(String name, int quantity) {
        return new Fruit(name, quantity);
    }
}
