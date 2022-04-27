package service.impl;

import model.Fruit;
import service.FruitService;

public class FruitServiceImpl implements FruitService {
    @Override
    public Fruit createFruit(String name) {
        return new Fruit(name);
    }
}
